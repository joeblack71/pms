
package com.myco.central.reservations.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myco.central.commons.exceptions.DaoException;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.service.impl.GenericServiceImpl;
import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.reservations.dao.ReservationDao;
import com.myco.central.reservations.domain.Guest;
import com.myco.central.reservations.domain.Reservation;
import com.myco.central.reservations.service.ReservationService;
import com.myco.central.reservations.web.vo.ReservationFilter;

@Service
public class ReservationServiceImpl extends GenericServiceImpl implements ReservationService {
	private ReservationDao reservationDao = null;

    public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	public ReservationServiceImpl() {
	}

	//////////////////
	/// Implementation
	//////////////////
	
    public String insert(Reservation item) throws ServiceException {
        String idReservation = null;

        try {
        	idReservation = reservationDao.insert(item);
        } catch (DaoException ex){ 
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return idReservation;
    }

    public boolean update(Reservation resv) throws ServiceException {
        boolean result = false;

        try {
        	reservationDao.update(resv);
        } catch (DaoException ex){ 
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }

        return result;
    }

    public Reservation search(Reservation item) throws ServiceException {
        Reservation res = null;

        try {
        	res = reservationDao.search(item);
        	
        } catch (DaoException ex){ 
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }
        
        return res;
    }

    public boolean delete(Reservation resv) throws ServiceException {
        boolean result = false;

        try {
        	reservationDao.delete(null);
        } catch (DaoException ex){ 
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }
		
		return result;
    }

    public List<Reservation> select(ReservationFilter filter)
    throws ServiceException {
        List<Reservation> list = new ArrayList<Reservation>();

        try {
        	list = reservationDao.select(filter);
        } catch (DaoException ex){ 
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }
        
        return list;
    }

    public void saveReservationInfo(Reservation res) throws ServiceException {
        
        try {
        	reservationDao.saveReservationInfo(res);
        } catch (DaoException ex){ 
        	log.info( ex.getMessage() );
        	throw new ServiceException(CentralModuleConstants.MESSAGE_SERVICE_EXCEPTION);
        }
        
    	
    }
    
    public List<Guest> getReservationGuests(Connection conn,
    		String idHotel,	String idReservation) throws ServiceException {
        List<Guest> list = new ArrayList<Guest>();

        /*try {
        	list = reservationDao.getReservationGuests(idHotel, idReservation);
        } catch (SQLException e){ 
        	e.printStackTrace();
        	throw new Exception();
        }*/
                
        return list;
    }

}
