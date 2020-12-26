package com.ashokit.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.demo.entity.State;

@Repository
public interface StateRepo extends JpaRepository<State, Integer>{
	
	List<State> findByCountryId(Integer countryId);
}
