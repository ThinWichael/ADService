package com.michael.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michael.beans.PersonalInfo;
import com.michael.beans.DAO.noSql.Advertisment;
import com.michael.beans.DAO.noSql.AdvertismentRepository;
import com.michael.cache.AdCachePool;
import com.michael.config.MySpringConfig;
import com.michael.service.AdService;
import com.michael.utils.Utils;
@Service
public class AdServiceImpl implements AdService {

//	@Autowired
//	private AdervtismentRepository adervtismentRepository;
	@Autowired
	AdCachePool adCachePool;
	@Autowired
	private MySpringConfig mySpringConfig;
	@Autowired
	private Utils utils;
	
	public AdServiceImpl() {
	}

	@Override
	public void getAdPoolCache() {
		
		if(mySpringConfig.isUseMockData()) {
			utils.getMockData();
		} else {
			utils.getRealData();
		}
	}

	@Override
	public Advertisment getAdToUser(String userId) throws CloneNotSupportedException {
		
		// check this User in HashMap if not put it into HashMap with a new AdList
		if(! adCachePool.personalAdMap.containsKey(userId) ||
				utils.isTimeMoreThanOneHour(userId) ) {
			adCachePool.personalAdMap.put(userId, utils.createPersonalInfo());
		}
		PersonalInfo userInfo = adCachePool.personalAdMap.get(userId);
		// random take a ad from personal ad list
		Advertisment ad = utils.getRandomAD(userInfo);
		// return
		return ad;
	}
	
}
