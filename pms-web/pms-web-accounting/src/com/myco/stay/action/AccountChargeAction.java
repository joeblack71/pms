
package com.myco.stay.action;

import com.myco.stay.form.AccountChargeForm;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

//import com.myco.central.dao.IntRoomDAO;
//import com.myco.central.dao.RoomDAO;
import com.myco.stay.vo.AccountCharge;
import com.myco.stay.dao.AccountChargeDAO;

public class AccountChargeAction extends MappingDispatchAction {
	Log log = LogFactory.getLog(AccountChargeAction.class);

    /**
	 * 
	 * @return una lista conteniendo los huespedes registrados en el sistema
	 * @throws ServletException
	 * @throws IOException
	 */
	public ActionForward accountChargeList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException {
		
		log.info("testing");
	    HttpSession session = request.getSession();
	    AccountChargeForm acForm = (AccountChargeForm)form; 

	    AccountChargeDAO dao = new AccountChargeDAO();
	    //IntRoomDAO rDao = new RoomDAO();
	    
	    List<DynaBean> list = null;
	    
	    String idHotel = "1";

	    try {
	    	//list = rDao.getRoomList(idHotel, "", "I");
		    System.out.println("rooms:"+list.size());
	    	acForm.setInHouseRooms(list);
	    } catch (Exception e) {
	        idHotel = "1"; //TODO remove
	    }

		return mapping.findForward("success");
	}

    public ActionForward accountChargeEdit(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response) {

        return mapping.findForward("success");
    }
    
    public ActionForward accountChargeUpdate(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request,HttpServletResponse response)
    throws ServletException, IOException {
    	
        HttpSession session = request.getSession();
        AccountChargeForm cForm = (AccountChargeForm)form; 

        /*SessionAttributes sesAttributes =
        	(SessionAttributes)session.getAttribute(Constants.SESSION_ATTRIBUTES);*/

        AccountCharge cust = new AccountCharge();
        AccountChargeDAO dao = new AccountChargeDAO();

        return mapping.findForward("success");
    }

}
