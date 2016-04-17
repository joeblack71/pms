package com.myco.central.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.core.io.FileSystemResource;

import com.myco.central.commons.model.Address;
import com.myco.central.commons.model.Customer;
import com.myco.central.commons.model.Phone;
import com.myco.central.commons.model.SourceType;
import com.myco.central.reservations.domain.Guest;
import com.myco.central.reservations.domain.Reservation;
import com.myco.central.reservations.domain.Room;

public class MockFactoryCentralTest {
	private static Customer customer;

	public static Customer newCustomer() {
		customer = new Customer();
		
		Address custAddress = new Address();

		//cust.setIdCustomer("");
		customer.setLastName1( MockFactory.getString("cust.lastname1") );
		customer.setLastName2( MockFactory.getString("cust.lastname2") );
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

        customer.setPhone1(new Phone(null, "2427799") );
        customer.setPhone2(new Phone(null, "3659988") );
        customer.setPhone3(new Phone(null, "998565486") );

		customer.setEmails("algo@dominio.com");

		customer.setDocumentNumber("");
		customer.setDocumentType("");

		customer.setIdSource("");

		customer.setVipStatus("");
		customer.setBirthDate("");
		customer.setHotelRegistration("01");
		customer.setNationality("");
		customer.setOccupation("");
		customer.setPreferredHotel("");
		customer.setPreferredRoom("");
		customer.setRequests("");

		customer.setMadeBy("");
		customer.setStatus("");
		
		return customer;
	}

	public static Reservation newReservation() {
		Reservation resv = new Reservation();

		resv.setIdHotel( MockFactory.getString("") );
		resv.setType("I");
		resv.setIdReservation("");
        resv.setArrival("15/02/2008");
        resv.setDeparture("16/02/2008");
        resv.setNights("1");
        resv.setFlight("LAN-535");
        resv.setAdults("1");
        resv.setChildren("0");
        resv.setQuantity("1");
        resv.setStatus("T");
        resv.setIdSource("9999");
        resv.setContactName("Contacto...");
        resv.setRoomType("1");
        resv.setIdPackage("");
        resv.setRoomNumber("1");
        resv.setRoomRate("150.50");
        resv.setTotal("150.50");
        resv.setPaymentDue("10/02/2008");
        resv.setPaymentType("01");
        resv.setVoucher("99999");
        resv.setMadeBy("JO.");
        resv.setUpdatedBy("JO.");
        resv.setHotelInstructions("Hotel instructions ...");
        resv.setGuestInstructions("Guest instructions ...");
        resv.setGuests(new ArrayList<Guest>());

        return resv;
	}

	public static Room newRoom() {
		Room room = new Room();

		room.setIdHotel("01");
		room.setIdRoomType("DB");
		room.setRoomNumber("0101");
		room.setDescription("DOBLE");
		room.setLocation("");
		room.setIdRoom("");
		room.setBedsCapacity("");
		room.setRoomRate("");
		room.setIdReservation("0");
		room.setConnectedRoom("");
		room.setRoomStatus("A");
		room.setHkStatus("");

		return room;
	}

	public static SourceType newSourceType() {
		SourceType bean = new SourceType();

		bean.setDescription("TESTING");
		bean.setAbbreviation("TEST");
		bean.setStatus("A");
		bean.setMadeBy("JO.");

		return bean;
	}

	public static List<Map<String,Object>> getAvailabilityRows() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("roomType", "MT");
		map.put("fromDate", new Date());
		map.put("toDate", new Date());
		
		list.add(map);
		
		map = new HashMap<String, Object>();
		
		map.put("roomType", "MT");
		map.put("fromDate", new Date());
		map.put("toDate", new Date());
		
		list.add(map);

		map = new HashMap<String, Object>();
		
		map.put("roomType", "MT");
		map.put("fromDate", new Date());
		map.put("toDate", new Date());
		
		list.add(map);

		return list;
		
	}

	/** Read the contents of the given file. */
	public static List<Map<String,Object>> retrieveReservationsData(String filename) throws IOException {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
	
		File file = new File("/tempo/resource.txt");
		Map<String,Object> data = null;
		String[] fields = null;
		
//		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(new FileInputStream(file));
		
//	    String NL = System.getProperty("line.separator");
//		String NL = System.getProperty(";");
		String text = "";
		
		System.out.println("Reading from file.");
		try {
			int i;
			while (scanner.hasNextLine()) {
				text = scanner.nextLine();
				fields = text.split(",");
		
				data = new HashMap<String,Object>();
				
				i=0;

				data.put("hotelId", fields[i++]);
				data.put("roomType", fields[i++]);
				data.put("fromDate", fields[i++]);
				data.put("toDate", fields[i++]);
			}
		} finally {
			scanner.close();
		}
//	    System.out.println("Text read in: " + text);
	    
	    return list;
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
