package com.michael.beans.api;

import com.michael.enums.Status;

public class APIResult<T> {

	private Integer status;
	private String description;
	
	private T data;
	
	public APIResult(Status status, String description) {
		this.status = status.getCode();
		this.description = description;
	}
	
	public APIResult(Status status) {
		this.status = status.getCode();
		this.description = status.getDescription();
	}
	
	public APIResult(Status status, String description, T data) {
		this.status = status.getCode();
		this.description = description;
		this.data = data;
	}
	
	public APIResult(Status status, T data) {
		this.status = status.getCode();
		this.description = status.getDescription();
		this.data = data;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public APIResult() {
		// TODO Auto-generated constructor stub
	}


}
