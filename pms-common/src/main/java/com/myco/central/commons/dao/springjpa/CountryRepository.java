package com.myco.central.commons.dao.springjpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myco.central.commons.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
	    List<Country> findByName(String lastName);
}
