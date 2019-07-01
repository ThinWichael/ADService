package com.michael.beans.DAO.noSql;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

// MongoDB Repository
public interface AdvertismentRepository extends MongoRepository<Advertisment,String> {

	public Advertisment findBy_id(String _id);
	public List<Advertisment> findAll();
}
