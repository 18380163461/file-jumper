package com.pvirtech.filejumper.test;

import java.io.File;
import org.junit.Test;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.ClientProtocolException;

@SuppressWarnings("deprecation")
public class BaseServiceSpringTest {
	
	@Test
	public  void testUpload() throws Exception {
		String url = "http://127.0.0.1:8019/filejumper/filejumper/singleUpload";
		File file = new File("F://文档//image.gif");
		String result = postFile(file, url);
		System.out.println(result);
	}

	@SuppressWarnings({ "resource" })
	public  String postFile(File file, String url)throws ClientProtocolException, IOException {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		FileBody fileBody = new FileBody(file);
		MultipartEntity reqEntity = new MultipartEntity();
		reqEntity.addPart("data", fileBody);
		httppost.setEntity(reqEntity);
		System.out.println("执行: " + httppost.getRequestLine());
		HttpResponse response = httpclient.execute(httppost);
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("statusCode is " + statusCode);
		if (statusCode == 200) {
			HttpEntity resEntity = response.getEntity();
			if (resEntity != null) {
				byte[] resData = EntityUtils.toByteArray(resEntity);
				String content = new String(resData, "utf-8");
				System.out.println(content);
				return content;
			}
		}
		return "";
	}

	
	@Test
	public void testDownload() throws Exception {
		String url = "http://127.0.0.1:8019/filejumper/filejumper/singleDownFile?fileName=";
		String fileName = "a489aab2-e17e-455a-b4b4-d188b0fb32f8-image.gif";
		@SuppressWarnings("resource")
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url + fileName);
		HttpResponse response = httpclient.execute(httpGet);
		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			HttpEntity entity = response.getEntity();
			byte[] datas = EntityUtils.toByteArray(entity);
			System.out.println("data_length=" + datas.length);
		}

	}
	
}
