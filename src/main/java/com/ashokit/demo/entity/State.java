package com.ashokit.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class State {
	
	@Id
	@GeneratedValue
	private Integer stateId;
	
	private String stateName;
	
	private Integer countryId;
}
