package com.pvirtech.filejumper.controller.common.constant;

public enum CommonCode {
	
	SUCCESS("请求成功","200"),
	REQUEST_PARAMETER_ERROR("请求参数出错","400"),
	SERVER_ERROR("服务器出错","500");
	
	private String msg;
	
	private String code;
	
	private  CommonCode(String msg,String code){
		this.msg  = msg;
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getMsg() {
		return this.msg;
	}
	
}
