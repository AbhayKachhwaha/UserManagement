package com.ashokit.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	private Integer userId;
	private String firstName;
	private String lastName;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	private Long phoneNum;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	private String gender;
	private String country;
	private String state;
	private String city;
	private String accntStatus;
	
	public User(String email, String password) {
		this.email=email;
		this.password=password;
	}
}
