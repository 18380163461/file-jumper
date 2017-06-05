package com.pvirtech.filejumper.controller.module.transfer;

import java.io.File;
import java.util.Map;
import java.util.Date;
import java.util.UUID;
import java.util.HashMap;
import java.util.Iterator;
import java.net.URLEncoder;
import java.io.OutputStream;
import java.io.FileInputStream;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pvirtech.filejumper.controller.common.dto.ResponseResult;
import com.pvirtech.filejumper.controller.common.util.ResultWrapper;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import com.pvirtech.filejumper.controller.module.transfer.dto.StorageFile;


@Controller("fileUploader")
@RequestMapping("filejumper")
public class FileUploader {
	
	
	/**
	 * 单文件上传
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("singleUpload")
	@ResponseBody
	public ResponseResult singleUpload(HttpServletRequest request,   HttpServletResponse response) throws Exception { 
		ResponseResult  responseResult = new  ResponseResult();
		ServletContext sc = request.getSession().getServletContext();  
	    CommonsMultipartResolver cmr = new CommonsMultipartResolver(sc);
	    StorageFile  storageFile  = new StorageFile();
	    if (cmr.isMultipart(request)) {  
	        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) (request);  
	        Iterator<String> files = mRequest.getFileNames();  
	        while (files.hasNext()) {  
	            MultipartFile mFile = mRequest.getFile(files.next());  
	            if (mFile != null) {  
	            	String originalFilename = mFile.getOriginalFilename();
	            	String storagePath = generateStoragePath(request);
	            	String storageName = generateStorageName(originalFilename);  
	            	storageFile.setStoragePath(storagePath+"\\"+storageName);
	            	storageFile.setStorageFileName(storageName);
	            	FileUtils.copyInputStreamToFile(mFile.getInputStream(), new File(storagePath,storageName));
	            }  
	        }  
	    }
		responseResult= ResultWrapper.wrapperSuccessCodeResult();
        Map<String,Object>  resultMap = new HashMap<String,Object>();
        resultMap.put("storageFile",storageFile );
		responseResult.setData(resultMap);
		responseResult.setSysTime(new Date());
	    return responseResult;  
	}  
	
	private  String  generateStorageName(String originalFilename){
		return UUID.randomUUID() + "-" + originalFilename;  
	}
	
	private String   generateStoragePath(HttpServletRequest request){
		 String storagePath = request.getSession().getServletContext().getRealPath("publishUpload");  
		 return storagePath;
	}
	
	@RequestMapping("/singleDownFile")  
	public void singleDownFile(HttpServletRequest request,HttpServletResponse response) {  
	    String fileName = request.getParameter("fileName");  
	    try {  
	        fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");  
	        ServletContext sc = request.getSession().getServletContext();  
	        String fileSaveRootPath = sc.getRealPath("publishUpload");   
	        File file = new File(fileSaveRootPath + "\\" + fileName);  
	        if (!file.exists()) {  
	            return;  
	        }  
	        String realname = fileName.substring(fileName.indexOf("_") + 1);  
	        response.setHeader("content-disposition", "attachment;filename="+ URLEncoder.encode(realname, "UTF-8"));  
	        FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName);  
	        OutputStream out = response.getOutputStream();  
	        byte buffer[] = new byte[1024];  
	        int len = 0;  
	        while ((len = in.read(buffer)) > 0) {  
	            out.write(buffer, 0, len);  
	        }  
	        in.close();  
	        out.close();  
	    } catch (Exception e) {  
	  
	    }  
	} 
	
	
	
}
