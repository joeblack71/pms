
package com.myco.central.reservations.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.myco.central.commons.service.SourceService;

public class SourceController extends GenericController {
	private SourceService sourceService;

	public SourceService getSourceService() {
		return sourceService;
	}

	public void setSourceService(SourceService sourceService) {
		this.sourceService = sourceService;
	}

	public ModelAndView sourceselect(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

//        Source filter = new Source();
//        
//        List<Map<String, Object>> list = null;
//
//        filter.setHotelRegistration(""); // TODO get session value
//        filter.setSourceName( request.getParameter("pattern") );
//        filter.setCommercialName("");
//        filter.setStatus("");
//
//        try {
//	        list = sourceService.select(filter);
//	        listForm.setselect(list);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
        
		return modelAndView;
    }

    public ModelAndView sourceEdit(HttpServletRequest request, 
    		HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

//        Source filter = new Source();
//
//        filter.setHotelRegistration("1");
//        filter.setIdSource( request.getParameter("idSource") );
//        //filter.setIdSource( "9" );
//        filter.setStatus("");
//
//        try {
//	        editForm.setItem( sourceService.search(filter) );
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}

        return modelAndView;
    }

    public ModelAndView sourceUpdate(HttpServletRequest request, 
    		HttpServletResponse response) throws ServletException {
        ModelAndView modelAndView = new ModelAndView();

//		ActionMessages messages = new ActionMessages();
//
//        SessionAttributes sessionAttributes =
//        	(SessionAttributes)session.getAttribute(CentralModuleConstants.SESSION_ATTRIBUTES);
//
//        SourceService sourceService = new SourceServiceImpl();
//        Source source = editForm.search();
//
//        source.setHotelRegistration("1"); // TESTING se extrae de sesion
//        //source.setMadeBy( sessionAttributes.getUserInitials() );
//        source.setMadeBy("JO.");
//        source.setUpdatedBy("JO.");
//
//        String idHotel = source.getHotelRegistration();
//        String idSource = source.getIdSource();
//
//        String result = StringUtils.EMPTY;
//
//        if ( StringUtils.isNotBlank(idHotel) ) {
//        	try {
//                if ( StringUtils.isNotBlank(idSource) ) {
//	        		result = sourceService.update(source);
//	        	} else {
//	        		idSource = sourceService.insert(source);
//	        		source.setIdSource(idSource);
//	        	}
//                if ( !result.equals(CentralModuleConstants.SUCCESSFUL_OPERATION) ) {
//                	chargeActionMessages(messages, request, "Source updating failed");
//                } else {
//                	chargeActionMessages(messages, request, "Source updating was successful !!");
//                }
//        	} catch(RuntimeException e) {
//        		//showException(e, request, messages);
//        		try {
//        			throw e.getCause();
//        		} catch (DuplicatedDocumentException ex) {
//        			chargeActionMessages(messages, request, "Duplicated Document Number !!");
//        		} catch (Throwable ex) {
//        			chargeActionMessages(messages, request, "Source updating failed");
//        		}
//	    	} catch(Exception e) {
//            	chargeActionMessages(messages, request, "Source updating failed");
//	    	}
//        } else {
//        	chargeActionMessages(messages, request, "Invalid Id Hotel");
//        }
//
//        if ( !messages.isEmpty() ) {
//        	saveMessages(request, messages);
//        }
        	
        return modelAndView;
    }

    //////////////////////
    /// Private Interface
    //////////////////////

//	private void showException(Exception e, HttpServletRequest request, ActionMessages messages) {
//		try {
//			throw e.getCause();
//		} catch (DuplicatedDocumentException ex) {
//			chargeActionMessages(messages, request, "Duplicated Document Number !!");
//		} catch (Throwable ex) {
//			System.err.println("Other Errors !!");
//		}
//	}
//
//	private void chargeActionMessages(ActionMessages messages, HttpServletRequest request, String message){
//		messages.add("errors", new ActionMessage("mess.value", message));
//		saveMessages(request, messages);
//	}

}
