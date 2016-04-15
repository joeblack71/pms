package com.myco.central.reservations.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myco.central.accounting.dao.AccountChargeDao;
import com.myco.central.accounting.dao.RoomAccountDao;
import com.myco.central.accounting.model.AccountCharge;
import com.myco.central.reservations.dao.RoomDao;

public class AccountChargeController extends GenericController {
	private AccountChargeDao accountChargeDao;
	private RoomDao roomDao;
	private RoomAccountDao roomAccountDao;
//	private UtilitiesDao utilitiesDao;

    /**
	 * 
	 * @return una lista conteniendo los huespedes registrados en el sistema
	 * @throws Exception
	 * @throws IOException
	 */
	public ModelAndView accountChargeselect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("");
		
	    List<Map<String, Object>> list = null;
	    List<AccountCharge> charges = null;
	    
	    String idHotel = "1";
	    String idCustomer = "1";
	    String idBill = request.getParameter("idBill");

	    try {
		    list = roomDao.select(null);
//	    	acForm.setInHouseRooms(list);

	    	list = roomAccountDao.select(idHotel, idCustomer, idBill);
//	    	acForm.setRoomAccounts(list);

//	    	acForm.setRoomBill( list.search(0) ); // carga el primer elemento de la lista
//	    	if ( idBill == null ) {
//	    		idBill = (String)acForm.getRoomBill().search("idBill");
//	    	}

	    	charges = accountChargeDao.getAccountCharges(idHotel, idCustomer, idBill);

//	    	acForm.setAccountCharges(charges);
	    	
	    	modelAndView.addObject("list", list);
	    	modelAndView.addObject("charges", charges);
	    } catch (Exception e) {
	    	log.info("Error al obtener cuentas de habitacion");
	    }

		return modelAndView;
	}

    public ModelAndView editCharge(HttpServletRequest request, 
    		HttpServletResponse response) throws Exception {
    	String idHotel = request.getParameter("idHotel");
    	String idCustomer = request.getParameter("idCustomer");
    	String idBill = request.getParameter("idBill");
    	log.info("pars:"+idHotel+";"+idCustomer+";"+idBill);

    	try {
//    		chForm.search().setIdHotel(idHotel);
//    		chForm.search().setIdCustomer(idCustomer);
//    		chForm.search().setIdBill(idBill);
//
//    		chForm.setCreditAccounts( uDao.getCreditAccountselect(idHotel,
//    				CentralModuleConstants.CREDIT_ACCOUNT, "") );
//    		chForm.setCheckTypes( uDao.getCheckTypeselect() );
    	} catch(Exception e) {
    		e.printStackTrace();
    	} 

        ModelAndView modelAndView = null;
		return modelAndView;
    }
    
    public ModelAndView updateCharge(HttpServletRequest request, 
    		HttpServletResponse response) throws Exception {

//    	AccountChargeDaoJdbc dao = new AccountChargeDaoJdbc(); 
    	//AccountCharge item = chForm.search();


    	try {
//    		dao.insert( chForm.search() );
    	} catch(Exception e) {
    		log.info("No se pudo actualizar el registro !!");
    	}
    	
        ModelAndView modelAndView = null;
		return modelAndView;
    }

    public ModelAndView accountChargeUpdate(HttpServletRequest request,
    		HttpServletResponse response) throws Exception {
    	
        /*HttpSession session = request.getSession();
        AccountChargeForm cForm = (AccountChargeForm)form;*/ 

        /*SessionAttributes sesAttributes =
        	(SessionAttributes)session.getAttribute(CentralModuleConstants.SESSION_ATTRIBUTES);*/

        /*AccountCharge cust = new AccountCharge();
        AccountChargeServiceImpl dao = new AccountChargeServiceImpl();*/

        ModelAndView modelAndView = null;
		return modelAndView;
    }

    /// Dependency Injection
    
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public void setRoomAccountDao(RoomAccountDao roomAccountDao) {
		this.roomAccountDao = roomAccountDao;
	}

	public void setAccountChargeDao(AccountChargeDao accountChargeDao) {
		this.accountChargeDao = accountChargeDao;
	}

}
