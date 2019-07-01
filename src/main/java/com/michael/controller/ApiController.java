package com.michael.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.michael.beans.api.APIResult;
import com.michael.beans.api.GetAdRequest;
import com.michael.beans.api.GetAdResponse;
import com.michael.enums.Status;
import com.michael.service.impl.AdServiceImpl;



@RestController
public class ApiController {

	private Logger logger = Logger.getLogger("ControllerLog");
	private final AdServiceImpl adServiceImpl;
	
	public ApiController(AdServiceImpl adServiceImpl) {
		// TODO Auto-generated constructor stub
		this.adServiceImpl = adServiceImpl;
	}

	@RequestMapping(value = "/getAD", method = RequestMethod.POST , produces = "application/json")
	public APIResult<GetAdResponse> getAd(@RequestBody @Valid GetAdRequest getAdRequest,
			HttpServletRequest req, HttpServletResponse res) throws CloneNotSupportedException {
		logger.info("getAd: " + req.getRemoteAddr());
		
		GetAdResponse getAdResponse = new GetAdResponse();
		getAdResponse.setAdervtisment( adServiceImpl.getAdToUser(getAdRequest.getUserId()));
		
		if(getAdResponse.getAdervtisment() == null)
			return new APIResult<GetAdResponse> (Status.NO_AD);
		
		return new APIResult<GetAdResponse>(Status.SUCCESS, getAdResponse);			
	}
	
}
