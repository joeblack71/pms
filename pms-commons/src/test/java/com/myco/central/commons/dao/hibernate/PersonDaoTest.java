/**
 *
 */
package com.myco.central.commons.dao.hibernate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.dao.PersonDao;
import com.myco.central.commons.model.Address;
import com.myco.central.commons.model.Contact;
import com.myco.central.commons.model.Person;

public class PersonDaoTest extends GenericDaoTest {
//    @Autowired
//    private SessionFactory sessionFactory;
    @Autowired
    private PersonDao personDao;

    private Address getDummyAddress() {
        Address address = new Address();
        address.setCountry("Peru");
        address.setCity("Lima");
        address.setDistrict("San Isidro");
        address.setZipCode("Lima27");
        address.setStreetType("Avenue");
        address.setStreetName("Javier Prado");
        address.setStreetNumber("1254");
        return address;
    }

    private Contact getDummyContact(Address address) {
        Contact contact = new Contact();
        contact.setFirstName("Pyotr II");
        contact.setLastName("Tchaikovsky");
        contact.setAddress(address);

        return contact;
    }

    private Person getDummyPerson(Address address) {
        Person person = new Person();
        person.setFirstName("Pyotr II");
        person.setLastName("Tchaikovsky");
        person.setAddress(address);
        return person;
    }

    @Test
    public void testFindPersonById() throws Exception {
        Person person = personDao.get(1l);

        assertNotNull("Null value returned", person);
    }

    @Test
    public void testFindPersonByLastName() throws Exception {
        personDao.search("Tchaikovsky");
    }

    @Test
    public void testSaveUpdateContact() throws Exception {
        Address address = getDummyAddress();
        Contact contact = getDummyContact(address);

        personDao.save(contact);
        assertNotNull(contact.getId());

    }

    @Test
    public void testSaveUpdatePerson() throws Exception {
        Address address = getDummyAddress();
        Person person = getDummyPerson(address);

        personDao.save(person);
        assertNotNull(person.getId());

    }

    @Test
    public void testSaveUpdateRemovePerson() throws Exception {
        Address address = getDummyAddress();
        //        Person person = getDummyPerson(address);
        Contact contact = getDummyContact(address);

        personDao.save(contact);
        assertNotNull(contact.getId());

        personDao.remove(contact);

        contact = (Contact) personDao.get(contact.getId());
        assertTrue(contact == null);
    }
}