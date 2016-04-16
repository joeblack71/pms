package com.myco.central.booking.service;

import com.myco.central.commons.model.Person;
import com.myco.central.commons.service.GenericService;

public interface PersonService extends GenericService<Person> {

	boolean validate(Person person);
}