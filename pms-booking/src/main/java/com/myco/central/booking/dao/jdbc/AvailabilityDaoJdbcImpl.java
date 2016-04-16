
package com.myco.central.booking.dao.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.myco.central.booking.dao.AvailabilityDao;
import com.myco.central.booking.dto.AvailabilityFilterDto;
import com.myco.central.booking.dto.OccupationByTypeDto;
import com.myco.central.booking.exceptions.DaoException;
import com.myco.central.commons.dao.jdbc.ConProvider;

public class AvailabilityDaoJdbcImpl implements AvailabilityDao {
	
	private static final Log logger = LogFactory.getLog(AvailabilityDaoJdbcImpl.class);

    @Override
	public List<OccupationByTypeDto> getOccupationByType(AvailabilityFilterDto filter)
			throws DaoException {
    	
    	List<OccupationByTypeDto> list = new ArrayList<>();
        String query = "SELECT tRoomType, dOccupationDay, COUNT(tRoomType)" +
                             " FROM occupation" +
                             " WHERE nHotelId = ? AND" +
                                   " dOccupationDay >= ? AND dOccupationDay <= ?" +
                                   " AND tStatus != 'X'" +
                             " GROUP BY tRoomType, dOccupationDay";

        Connection con = null;
        PreparedStatement pstmt = null;
		try {
	    	con = ConProvider.getMySqlConnection();
            pstmt = con.prepareStatement(query);
            int k = 1;
            pstmt.setLong(k++, filter.getHotelId());
			pstmt.setDate(k++, Date.valueOf(filter.getStartDate()));
			pstmt.setDate(k, Date.valueOf(filter.getEndDate()));
            ResultSet rs = pstmt.executeQuery();
            while( rs.next() ) {
                OccupationByTypeDto od = new OccupationByTypeDto();
                od.setRoomType(rs.getString(1));
                od.setOccupationDate(rs.getDate(2));
                od.setOccupationRooms(rs.getInt(3));
                list.add(od);
            }
        } catch (SQLException e) { 
			logger.info(e);
        } catch (com.myco.central.commons.exceptions.DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
        	if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					logger.info(e);
				}
			}
		}
        
        return list;
    }

    @Override
	public List<OccupationByTypeDto> getOccupationOnStay(AvailabilityFilterDto filter)
    	throws DaoException {
    	Connection con = null;
        CallableStatement cstmt = null;
    	ResultSet rs = null;
    	
    	List<OccupationByTypeDto> list = new ArrayList<>();
        int k = 0;
        
        try {
        	con = ConProvider.getMySqlConnection();
            cstmt = con.prepareCall("call sp_available_stay(?,?,?,?,?)");
            cstmt.setLong(k++, filter.getHotelId());
            cstmt.setString(k++, filter.getRoomType());
			cstmt.setDate(k++, Date.valueOf(filter.getStartDate()));
			cstmt.setDate(k++, Date.valueOf(filter.getEndDate()));
			cstmt.setString(k, filter.getStatus().name());
            rs = cstmt.executeQuery();
            while( rs.next() ) {
                OccupationByTypeDto od = new OccupationByTypeDto();
                od.setRoomType(rs.getString(1));
                od.setOccupationDate(rs.getDate(2));
                od.setOccupationRooms(rs.getInt(3));
                list.add(od);
            }
        } catch (SQLException e) { 
			logger.info(e);
        } catch (com.myco.central.commons.exceptions.DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
        	if (cstmt != null) {
				try {
					cstmt.close();
				} catch (SQLException e) {
					logger.info(e);
				}
			}
		}
        
        return list;
    }

	@Override
	public List<OccupationByTypeDto> getOccupationByRoom(AvailabilityFilterDto filter) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}