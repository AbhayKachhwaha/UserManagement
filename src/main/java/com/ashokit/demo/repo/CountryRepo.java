package com.ashokit.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.demo.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer>{

}
