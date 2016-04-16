package com.myco.central.accounting.service;

import java.util.List;
import java.util.Map;

import com.myco.central.accounting.dao.RoomAccountDao;
import com.myco.central.commons.service.impl.GenericServiceImpl;

public class RoomAccountServiceImpl extends GenericServiceImpl implements RoomAccountService {
    private RoomAccountDao roomAccountDao;

    public void setRoomAccountDao(RoomAccountDao roomAccountDao) {
	}

	public List<Map<String, Object>> select(String idHotel, String idCustomer, String idBill)
    throws Exception {
        List<Map<String, Object>> list = null;;

        try {
        	list = roomAccountDao.select(idHotel, idCustomer, idBill);
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }

        return list;
    }

}
