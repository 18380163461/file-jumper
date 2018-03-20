package com.pvirtech.filejumper.controller.common.util;

import com.pvirtech.filejumper.controller.common.constant.CommonCode;
import com.pvirtech.filejumper.controller.common.dto.ResponseResult;

/**
 * 
 *对服务端接口常用返回状态码进行包装
 *
 */
public class ResultWrapper {
	
	public static ResponseResult wrapperResult(String code,String msg) {
		ResponseResult responseResult  = new ResponseResult() ;
		responseResult.setCode(code);
		responseResult.setMsg(msg);
		return responseResult;
	}
	
	public static ResponseResult wrapperSuccessCodeResult(){ 
		ResponseResult responseResult  = new ResponseResult() ;
		responseResult.setCode(CommonCode.SUCCESS.getCode());
		responseResult.setMsg(CommonCode.SUCCESS.getMsg());
		return responseResult;
	}
	
	
	public static ResponseResult wrapperRequestParameterErrorCodeResult(){ 
		ResponseResult responseResult  = new ResponseResult() ;
		responseResult.setCode(CommonCode.REQUEST_PARAMETER_ERROR.getCode());
		responseResult.setMsg(CommonCode.REQUEST_PARAMETER_ERROR.getMsg());
		return responseResult;
	}
	
	public static ResponseResult wrapperServerErrorCodeResult(){ 
		ResponseResult responseResult  = new ResponseResult() ;
		responseResult.setCode(CommonCode.SERVER_ERROR.getCode());
		responseResult.setMsg(CommonCode.SERVER_ERROR.getMsg());
		return responseResult;
	}
	
}
