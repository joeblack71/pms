package reservations.action;

import java.util.List;

import com.myco.central.model.FlashStatusBean;
import com.myco.central.model.RoomTypeStatus;

import servletunit.struts.MockStrutsTestCase;

public class TestRoomTypeStatusAction extends MockStrutsTestCase {

	public TestRoomTypeStatusAction(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		setConfigFile("WEB-INF/struts-config-central.xml");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFlashStatus() {
		FlashStatusBean flashStatusBean = null; 

		setRequestPathInfo("/flashStatus");

		addRequestParameter("idHotel", "1");
		addRequestParameter("idRoomType", "1");
		addRequestParameter("statusDate", "2009-01-08");

		actionPerform();

		flashStatusBean = (FlashStatusBean)getRequest().getAttribute("flashStatusBean");
        assertTrue( flashStatusBean.getRows() == 10 );
        assertTrue( flashStatusBean.getStartDate().equals("2009-01-01") );
		//verifyNoActionMessages();
		//verifyActionMessages( new String[] {"mess.value"} );
		verifyForward("success");
	}

}
