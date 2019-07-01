package com.michael.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.michael.beans.PersonalInfo;
import com.michael.beans.DAO.noSql.Advertisment;
import com.michael.beans.DAO.noSql.AdvertismentRepository;
import com.michael.cache.AdCachePool;
import com.michael.config.MySpringConfig;

@Service
//@EntityScan(basePackages = { "com.michael.beans.DAO.noSql" })
//@EnableMongoRepositories(basePackages = { "com.michael.beans.DAO.noSql" })
public class Utils {

	@Autowired
	private AdvertismentRepository adervtismentRepository;
	@Autowired
	AdCachePool adCachePool;
	@Autowired
	private MySpringConfig mySpringConfig;
	
	public boolean isTimeMoreThanOneHour(String userId) {
		Date now = new Date();
		return now.after(adCachePool.personalAdMap.get(userId).getFirstTimeAfterOneHour());
	}

	public PersonalInfo createPersonalInfo() throws CloneNotSupportedException {
		PersonalInfo pi = new PersonalInfo(new Date(), mySpringConfig.getAdRefreshGap());

		pi.setPersonalAdList(createCloneAdCache());
		return pi;
	}

	public ArrayList<Advertisment> createCloneAdCache() throws CloneNotSupportedException {
		ArrayList<Advertisment> clone = new ArrayList<Advertisment>();

		HashMap<String, Advertisment> targetMap = adCachePool.getAdMapCache();

		for (String ad : targetMap.keySet()) {
			clone.add((Advertisment) targetMap.get(ad).clone());
		}
		
		return clone;
	}

	public Advertisment getRandomAD(PersonalInfo userInfo) throws CloneNotSupportedException {
		List<Advertisment> userAdList = userInfo.getPersonalAdList();
		Random rand = new Random();
		int ranNum = rand.nextInt(userAdList.size());
		Advertisment randomAd = userAdList.get(ranNum);
		// count down
		randomAd.setCapNum(randomAd.getCapNum() - 1);

		if (randomAd.getCapNum() <= 0)
			userAdList.remove(ranNum);

		if(userAdList.size() == 0)
			userInfo.setPersonalAdList(createCloneAdCache());
		
		return adCachePool.getAdMapCache().get(randomAd.get_id());
	}

	public void getRealData() {
		HashMap<String, Advertisment> cacheAdMap = new HashMap<>();
		
		for (Advertisment ad : adervtismentRepository.findAll()) {
			cacheAdMap.put(ad.get_id(), ad);
		}
		adCachePool.setAdMapCache(cacheAdMap);
	}

	public void getMockData() {
		List<Advertisment> mockDataList = new ArrayList<>();
		Advertisment ad1 = new Advertisment("aaa001", "Go check it out - FB ", "https://www.facebook.com/", 60, 3);
		Advertisment ad2 = new Advertisment("aaa002", "Go check it out - Google ", "https://www.google.com/", 60, 3);
		Advertisment ad3 = new Advertisment("aaa003", "Go check it out - Youtube  ", "https://www.youtube.com/", 60, 3);
		mockDataList.add(ad1);
		mockDataList.add(ad2);
		mockDataList.add(ad3);

		HashMap<String, Advertisment> cacheAdMap = new HashMap<>();

		for (Advertisment ad : mockDataList) {
			cacheAdMap.put(ad.get_id(), ad);
		}
		adCachePool.setAdMapCache(cacheAdMap);
	}

	public Utils() {
		// TODO Auto-generated constructor stub
	}

}
