package com.michael.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "myconfig")
public class MySpringConfig {

	private boolean useMockData;
	
    private String adRefreshGap; // min, hour
	
	public String getAdRefreshGap() {
		return adRefreshGap;
	}

	public void setAdRefreshGap(String adRefreshGap) {
		this.adRefreshGap = adRefreshGap;
	}

	public MySpringConfig() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isUseMockData() {
		return useMockData;
	}

	public void setUseMockData(boolean useMockData) {
		this.useMockData = useMockData;
	}
}
