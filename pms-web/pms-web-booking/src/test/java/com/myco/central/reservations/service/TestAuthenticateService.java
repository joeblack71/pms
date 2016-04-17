package reservations.service;

import com.myco.central.commons.security.service.AuthenticationService;
import com.myco.central.commons.security.service.impl.AuthenticationServiceImpl;
import com.myco.central.model.User;
import com.myco.central.model.UserMenu;
import com.myco.central.reservations.service.UserService;
import com.myco.central.reservations.service.impl.UserServiceImpl;

import servletunit.struts.MockStrutsTestCase;

public class TestAuthenticateService extends MockStrutsTestCase {
	AuthenticationService authenticateService = null;
	UserService userService = null;

	public TestAuthenticateService(String name) {
		super(name);
		this.authenticateService = new AuthenticationServiceImpl();
		this.userService = new UserServiceImpl();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	 // Mock
	/*public void testGetUserOptions() {
		setRequestPathInfo("/Authenticate");
		addRequestParameter("idHotel","1");
		addRequestParameter("login","super");
		addRequestParameter("password","");
		actionPerform();
	}*/

	public void testGetUserOptions() {
		User appUser = new User();
        UserMenu menu = null;
		
		boolean result = false;

		appUser.setIdHotel("1");
		appUser.setLogin("root");
		appUser.setPassword("root");
		result = authenticateService.authenticateUser(appUser);

		assertTrue(result);

        try {
			menu = userService.getUserMenu(appUser);
			assertTrue("Menu optiions coldn't be gotten !!", menu != null);
			System.out.println("options:" + menu.getOptions().size());
			assertTrue(menu.getOptions().size() > 0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
