package com.myco.central.commons.service;


public class LoginServiceTest {//extends MockStrutsTestCase {
//	LoginService loginService = null;
//	IAppUserService appUserService = null;
//
//	public TestLoginService(String name) {
//		super(name);
//		this.loginService = new LoginService();
//		this.appUserService = new AppUserService();
//	}
//
//	protected void setUp() throws Exception {
//		super.setUp();
//	}
//
//	protected void tearDown() throws Exception {
//		super.tearDown();
//	}
//
//	 // Mock
//	/*public void testGetUserOptions() {
//		setRequestPathInfo("/Authenticate");
//		addRequestParameter("idHotel","1");
//		addRequestParameter("login","super");
//		addRequestParameter("password","");
//		actionPerform();
//	}*/
//
//	public void testGetUserOptions() {
//		AppUser appUser = new AppUser();
//        UserMenu menu = null;
//		
//		boolean result = false;
//
//		appUser.setIdHotel("1");
//		appUser.setLogin("root");
//		appUser.setPassword("root");
//		result = loginService.authenticateUser(appUser);
//
//		assertTrue(result);
//
//        try {
//			menu = appUserService.getUserMenu(appUser);
//			assertTrue("Menu optiions coldn't be gotten !!", menu != null);
//			System.out.println("options:" + menu.getOptions().size());
//			assertTrue(menu.getOptions().size() > 0);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//
}
