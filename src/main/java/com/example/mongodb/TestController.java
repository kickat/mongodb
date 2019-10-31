package com.example.mongodb;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@GetMapping("add")
	public void add() {
		User user = new User("1234", "test", 18, 2, new Date());
		mongoTemplate.save(user);
	}
	
	@GetMapping("update/{userId}")
	public void update(@PathVariable String userId) {
		Query query = new Query(Criteria.where("_id").is(userId));
		User user = mongoTemplate.findOne(query , User.class);
		log.info(user.toString());
		user.setBirthDate(new Date());
		mongoTemplate.save(user);
	}
	
	@GetMapping("delete/{userId}")
	public void delete(@PathVariable String userId) {
		Query query = new Query(Criteria.where("_id").is(userId));
		mongoTemplate.remove(query, User.class);
	}
	
	@GetMapping("get/{name}")
	public Object get(@PathVariable String name) {
		Query query = new Query(Criteria.where("name").is(name));
		return mongoTemplate.findOne(query , User.class);
	}
}
