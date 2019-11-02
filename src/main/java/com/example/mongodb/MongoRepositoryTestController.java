package com.example.mongodb;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("repo")
public class MongoRepositoryTestController {
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("add")
	public void add() {
		User user = new User("1234", "test", 18, 2, new Date());
		userRepository.save(user);
	}
	
	@GetMapping("update/{userId}")
	public void update(@PathVariable String userId) {
		User user = userRepository.findById(userId).get();
		log.info(user.toString());
		user.setBirthDate(new Date());
		userRepository.save(user);
	}
	
	@GetMapping("delete/{userId}")
	public void delete(@PathVariable String userId) {
		userRepository.deleteById(userId);
	}
	
	@GetMapping("get/{name}")
	public Object get(@PathVariable String name) {
		return userRepository.findByName(name);
	}
}
