package com.experis.reto.entity;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;

public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private int age;
	private Date deathDateprob;

	public Customer() {

	}

	public Customer(int id, String firstName, String lastName, Date birthDate, int age, Date deathDateprob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.age = age;
		this.deathDateprob = deathDateprob;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDeathDateprob() {
		return deathDateprob;
	}

	public void setDeathDateprob(Date deathDateprob) {
		this.deathDateprob = deathDateprob;
	}

}
