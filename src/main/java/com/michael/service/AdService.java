package com.michael.service;

import com.michael.beans.DAO.noSql.Advertisment;

public interface AdService {

	void getAdPoolCache();
	
	Advertisment getAdToUser(String userId) throws CloneNotSupportedException;
}
