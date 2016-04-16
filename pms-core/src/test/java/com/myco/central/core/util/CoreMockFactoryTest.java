package com.myco.central.core.util;

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

import com.myco.central.model.Room;
import com.myco.central.model.SourceType;

public class CoreMockFactoryTest {

	public static Room newRoom() {
		Room room = new Room();

		room.setHotelId(1l);
		room.setRoomTypeId(1l);
		room.setRoomNumber("0101");
		room.setDescription("DOBLE");
		room.setLocation("");
		room.setBedsCapacity(3);
		room.setRoomRate(50.00);
		room.setReservationId(1l);
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
		bean.setCreatedBy("JO.");

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
