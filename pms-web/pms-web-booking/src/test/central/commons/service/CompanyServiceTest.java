package com.myco.central.commons.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.model.Company;

public class CompanyServiceTest extends AbstractCommonsBaseTest {

	@Autowired
	private CompanyService companyService; 
	
	private Company company = null; 

	@Test
	public void registerCompany() throws Exception {
		companyService.insert(company);
	}

	public void updateCompany() throws Exception {
		fail("Not yet implemented");
	}

	public void searchCompany() throws Exception {
		fail("Not yet implemented");
	}

	public void inactiveCompany() throws Exception {
		fail("Not yet implemented");
	}

	public void reportCompany() throws Exception {
		fail("Not yet implemented");
	}

	/// Dependency Injection
	
	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

}
