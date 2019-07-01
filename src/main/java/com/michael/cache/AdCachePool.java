package com.michael.cache;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.michael.beans.PersonalInfo;
import com.michael.beans.DAO.noSql.Advertisment;

@Component
public class AdCachePool {

	private HashMap<String, Advertisment> adMapCache;

	public ConcurrentHashMap<String, PersonalInfo> personalAdMap;
	
	public AdCachePool() {		
		// get adlist
		
		personalAdMap = new ConcurrentHashMap<String, PersonalInfo>();
	}

	public HashMap<String, Advertisment> getAdMapCache() {
		return adMapCache;
	}

	public void setAdMapCache(HashMap<String, Advertisment> adMapCache) {
		this.adMapCache = adMapCache;
	}
	
}
