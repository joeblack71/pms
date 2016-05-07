/**
 *
 */
package com.myco.central.commons.dao.hibernate;

import java.util.List;

import com.myco.central.commons.dao.PersonDao;
import com.myco.central.commons.model.Person;

//@Repository("personDao")
public class PersonDaoHIbernate extends GenericDaoHibernate<Person, Long> implements PersonDao {

    public PersonDaoHIbernate() {
        super(Person.class);
    }

    @Override
	// @Transactional
	public List<Person> getAll(String lastName) {
		// return
		// getSession().createCriteria(Person.class).add(Restrictions.eq("lastName",
		// lastName)).list();
		return null;
    }

}