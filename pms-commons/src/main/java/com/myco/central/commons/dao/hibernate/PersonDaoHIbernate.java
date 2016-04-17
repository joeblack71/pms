/**
 *
 */
package com.myco.central.commons.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.myco.central.commons.dao.PersonDao;
import com.myco.central.commons.model.Person;

//@Repository("personDao")
public class PersonDaoHIbernate extends GenericDaoHibernate<Person, Long> implements PersonDao {

    public PersonDaoHIbernate() {
        super(Person.class);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.myco.central.commons.dao.PersonDao#findById(java.lang.Long)
     */
    @Override
	// @Transactional
    public Person get(Long id) {
        return getSession().get(Person.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
	// @Transactional
    public List<Person> search(String lastName) {
        return getSession().createCriteria(Person.class).add(Restrictions.eq("lastName", lastName)).list();
    }

    @Override
	// @Transactional
    public void remove(Person person) {
        super.remove(person);
    }

}