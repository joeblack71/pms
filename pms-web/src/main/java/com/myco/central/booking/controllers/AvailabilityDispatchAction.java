
package com.myco.central.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import com.myco.central.dao.AvailabilityDAO;
import com.myco.central.form.AvailabilityForm;
import com.myco.central.util.AvailabilityArray;
import com.myco.central.vo.OccupationDay;
import com.myco.central.vo.RoomType;

public class AvailabilityDispatchAction extends MappingDispatchAction {

    /**
     * Carga una lista con la ocupacion esperada para un periodo
     * determinado. Esta informacion es utilizada en la preparacion
     * de los cuadros de ocupacion y disponibilidad.
     * @param aq es un objeto <B>Availability</B>, cuyos atributos se utilizan
     * para consulta en BB.DD.
     */

	public ActionForward availabilityShow(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {

    	AvailabilityForm aForm = (AvailabilityForm)form; 
        HttpSession session = request.getSession();
        //TODO charge room types
        List<RoomType> roomTypes = new ArrayList<RoomType>();
        List<OccupationDay> list = null;

        String hotelId = (String)session.getAttribute("hotel");
        String startDate = request.getParameter("startDate");
        String endDate   = request.getParameter("endDate");
        String period    = request.getParameter("period");
        String status    = request.getParameter("status");

        RoomType rt = new RoomType();
        rt.setRoomType("ES");
        roomTypes.add(rt);
        RoomType rt2 = new RoomType();
        rt.setRoomType("SJ");
        roomTypes.add(rt2);
        //TODO change this
        java.sql.Date sqlDate = new java.sql.Date(07,11,05);
        
        AvailabilityDAO dao = new AvailabilityDAO();
        try {
			list = dao.chargeOccupationByType(hotelId, startDate, endDate, period, status);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		period = "1";
        AvailabilityArray aa = new AvailabilityArray(period);
        String[][] matrix = aa.chargeRoomsOccupation(list, sqlDate, period, roomTypes);
        
        request.setAttribute("matriz", matrix);

        return mapping.findForward("success");
    }

}
