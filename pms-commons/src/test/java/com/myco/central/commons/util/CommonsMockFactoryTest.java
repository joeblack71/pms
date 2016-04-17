package com.myco.central.commons.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.FileSystemResource;

import com.myco.central.commons.model.Address;
import com.myco.central.commons.model.Customer;

public class CommonsMockFactoryTest {
	private static Customer customer;

	public static Customer newCustomer() {
		customer = new Customer();
		
		Address custAddress = new Address();

		//cust.setIdCustomer("");
//		customer.setLastName1( MockFactory.getString("cust.lastname1") );
//		customer.setLastName2( MockFactory.getString("cust.lastname2") );
		customer.setFirstName( MockFactory.getString("cust.firstname") );
		customer.setTitle( MockFactory.getString("cust.title") );

		custAddress.setStreetType("1"); // Avenue
		custAddress.setStreetName(""); // La Floresta
		custAddress.setStreetNumber(""); // 135
		custAddress.setComplement(""); // Dpto. 304
		custAddress.setCountry("1"); // Peru
		custAddress.setCity("");
		custAddress.setDistrict("");
		custAddress.setZipCode("");
		
		customer.setAddress(custAddress);

//        customer.setPhone1(new Phone(null, "2427799") );
//        customer.setPhone2(new Phone(null, "3659988") );
//        customer.setPhone3(new Phone(null, "998565486") );

//		customer.setEmails("algo@dominio.com");

		customer.setDocumentNumber("");
		customer.setDocumentType("");

//		customer.setIdSource("");

//		customer.setVipStatus("");
		customer.setBirthDate("");
//		customer.setHotelRegistration("01");
		customer.setNationality("");
		customer.setOccupation("");
//		customer.setPreferredHotel("");
		customer.setPreferredRoom("");
		customer.setRequests("");

//		customer.setMadeBy("");
//		customer.setStatus("");
		
		return customer;
	}

	public List<Map<String,Object>> getList(String filename) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		File file = new File("/tempo/resource.txt");
		FileSystemResource fsr = new FileSystemResource(file);
		
		if (fsr.exists()) {
			fsr.getFile();
			System.out.println("Exist");
		}
		
		return list;
	}

}
