package com.myco.central.web.accounting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.myco.central.accounting.dao.AccountChargeDao;
import com.myco.central.accounting.model.AccountCharge;
import com.myco.central.accounting.model.RoomAccount;
import com.myco.central.accounting.service.RoomAccountService;
import com.myco.central.web.controller.GenericController;

public class AccountChargeController extends GenericController {

	@Autowired
	private RoomAccountService roomAccountService;
	@Autowired
	private AccountChargeDao accountChargeService;
	
    /**
	 * 
	 * @return una lista conteniendo los huespedes registrados en el sistema
	 * @throws Exception
	 * @throws IOException
	 */
	public ModelAndView accountChargeselect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("");
		
	    List<RoomAccount> list = null;
	    List<AccountCharge> charges = null;
	    
	    Long hotelId = Long.valueOf(1);
	    Long customerId = Long.valueOf(1);

	    try {
	    	Long idBill = Long.valueOf(request.getParameter("idBill"));

//	    	list = roomAccountDao.get(idBill);
//	    	acForm.setInHouseRooms(list);

	    	list = roomAccountService.search(hotelId, customerId, idBill);
//	    	acForm.setRoomAccounts(list);

//	    	acForm.setRoomBill( list.search(0) );
//	    	if ( idBill == null ) {
//	    		idBill = (String)acForm.getRoomBill().search("idBill");
//	    	}

	    	charges = accountChargeService.getAccountCharges(hotelId, customerId, idBill);

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

}
