
package com.myco.central.reservations.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myco.central.commons.service.impl.GenericServiceImpl;
import com.myco.central.reservations.dao.PeriodDao;
import com.myco.central.reservations.domain.SpecialRate;
import com.myco.central.reservations.service.PeriodService;

public class PeriodServiceImpl extends GenericServiceImpl implements PeriodService {
	private PeriodDao periodDao;

    public PeriodDao getPeriodDao() {
		return periodDao;
	}

	public void setPeriodDao(PeriodDao periodDao) {
	}

    public PeriodServiceImpl() {}

    public List<Map<String, Object>> getPeriodselect(String idHotel, String pattern)
    throws Exception {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        try {
        	list = periodDao.getPeriodselect(idHotel, pattern);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
        
        return list;
    }
    
    public SpecialRate getSpecialRate(String idHotel, String idSpecialRate)
    throws Exception {
    	SpecialRate sr = null;

        try {
        	sr = periodDao.getSpecialRate(idHotel, idSpecialRate);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
	    
	    return sr;
	}
    
    public void insert(SpecialRate rate) throws Exception {
        try {
        	periodDao.insert(rate);
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public void update(SpecialRate rate) throws Exception {
        try {
        	periodDao.update(rate);
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    public void remove(SpecialRate specialRaet)
    throws Exception {
        try {
        	periodDao.remove(null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    ///
    // AJAX methods
    ///

    public void addRoomTypeRate(String idHotel, String roomType, String idRate)
    throws Exception {
        try {
        	periodDao.addRoomTypeRate(idHotel, roomType, idRate);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

}