package com.experis.reto.entity;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;

//Tambien se pudo haber implementado lombox
//import lombok.Data;

//@Data
public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private Date birthDay;
	private int age;
	
	public Customer(int id, String firstName, String lastName, Date birthDay, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
