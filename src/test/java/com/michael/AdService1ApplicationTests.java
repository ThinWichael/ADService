package com.michael;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.michael.config","com.michael.controller",
		"com.michael.utils", "com.michael.beans.DAO.noSql"})
//@EntityScan(basePackages = { "com.michael.beans.DAO.noSql" })
//@EnableMongoRepositories(basePackages = { "com.michael.beans.DAO.noSql" })
public class AdService1ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
