package com.example.mongodb;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.ToString;

@ToString
public class User {
	@Id
	private String userId;
	private String idNumber;
	private String name;
	private Integer age;
	private Integer gender;
	private Date birthDate;
	
	public User(String idNumber, String name, Integer age, Integer gender, Date birthDate) {
		this.idNumber = idNumber;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
