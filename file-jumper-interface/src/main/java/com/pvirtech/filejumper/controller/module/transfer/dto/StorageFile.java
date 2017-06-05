package com.pvirtech.filejumper.controller.module.transfer.dto;

import com.richinfo.player.entity.modules.common.bean.BaseBean;

public class StorageFile extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = -735555089722689038L;
	
	private String  storagePath;
	private String  storageFileName;
	
	
	public String getStoragePath() {
		return storagePath;
	}

	public void setStoragePath(String storagePath) {
		this.storagePath = storagePath;
	}

	public String getStorageFileName() {
		return storageFileName;
	}

	public void setStorageFileName(String storageFileName) {
		this.storageFileName = storageFileName;
	}
	
	
}
