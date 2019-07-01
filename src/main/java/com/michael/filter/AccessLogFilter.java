package com.michael.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// for all URL
@Component
@Order(1)
public class AccessLogFilter implements Filter{

	private Logger logger = Logger.getLogger("FilterLog");
	
	public AccessLogFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		logger.info("AccessLogFilter: " + req.getRequestURI() + " | " + req.getRemoteAddr());
		
		chain.doFilter(request, response);
	}

}
