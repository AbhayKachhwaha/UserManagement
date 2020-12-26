package com.ashokit.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue
	private Integer userId;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String password;
	private Long phoneNum;
	private Date dateOfBirth;
	private String gender;
	private Country country;
	private State state;
	private City city;
	private String accntStatus;
}
