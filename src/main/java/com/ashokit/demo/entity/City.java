package com.ashokit.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class City {
	
	@Id
	@GeneratedValue
	private Integer cityId;
	
	private String cityName;
	
	private Integer stateId;
	
}
