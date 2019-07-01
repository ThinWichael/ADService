package com.michael.beans.api;

public class GetAdRequest {

	String userId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public GetAdRequest(String userId) {
		this.userId = userId;
	}

	public GetAdRequest() {
		// TODO Auto-generated constructor stub
	}

}
