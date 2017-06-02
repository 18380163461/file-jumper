package com.pvirtech.filejumper.controller.common.dto;

import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
import com.richinfo.player.entity.modules.common.bean.BaseBean;

/**
 *
 * 接口返回结果对象
 *
 */
public class ResponseResult extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7841015087483845805L;
	
	private String code;
	private String msg;
	private Date   sysTime;
	private Object data;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@JSONField (format="yyyy-MM-dd HH:mm:ss") 
	public Date getSysTime() {
		return sysTime;
	}
	
	public void setSysTime(Date sysTime) {
		this.sysTime = sysTime;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
}
