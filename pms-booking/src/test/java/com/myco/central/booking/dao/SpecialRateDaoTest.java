package com.myco.central.booking.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.myco.central.booking.model.SpecialRate;
import com.myco.central.booking.utils.AbstractBookingBaseTest;

public class SpecialRateDaoTest extends AbstractBookingBaseTest {
    private SpecialRateDao specialRateDao;

    @Test
    public void addRoomTypeRate() {
        fail("Not yet implemented");
    }

    @Test
    public void deleteSpecialRate() {
        fail("Not yet implemented");
    }

    @Test
    public void getSpecialRoomRate() {
        fail("Not yet implemented");
    }

    @Test
    public void insertSpecialRate() {
        fail("Not yet implemented");
    }

    @Test
    public void searchSpecialRate() {
        fail("Not yet implemented");
    }

    @Test
    public void select() {
        List<SpecialRate> list = null;

        Long idHotel = 1l;
        String description = "";
        String status = "";

        try {
            list = specialRateDao.search(idHotel, description, status);
        } catch (com.myco.central.booking.exceptions.DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    public void updateSpecialRate() {
        fail("Not yet implemented");
    }

}
