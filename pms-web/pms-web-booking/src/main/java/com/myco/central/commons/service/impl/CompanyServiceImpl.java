
package com.myco.central.commons.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.CompanyDao;
import com.myco.central.commons.model.Company;
import com.myco.central.commons.service.CompanyService;

public class CompanyServiceImpl extends GenericServiceImpl implements CompanyService {
	private CompanyDao companyDao;

	public CompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	public void setRoomDao(CompanyDao companyDao) {
	}

	public CompanyServiceImpl() {}
   
    public String insert(Company company) throws Exception{
        String idCompany = null;

        try {
        	idCompany = companyDao.insert(company);
        } catch (Exception e){
        	e.printStackTrace();
        	throw new Exception();
        }

        return idCompany;
    }

    public boolean update(Company company) throws Exception {
        boolean result = false;

        try {
        	result = companyDao.update(company);
        } catch (Exception e){
        	e.printStackTrace();
        	throw new Exception();
        }

        return result;
    }

    public Company search(Company filter) throws Exception {
    	Company company = null;

        try {
        	company = companyDao.search(filter);
        } catch (Exception e){
        	e.printStackTrace();
        	throw new Exception();
        }

        return company;
    }

    public boolean delete(Company company) throws Exception {
        boolean result = false;

        try {
        	result = companyDao.delete(company);
        } catch (Exception e){
        	e.printStackTrace();
        	throw new Exception();
        }

        return result;
    }

    public List<Map<String, Object>> select(java.util.Map<String, Object> params)
    throws Exception {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

//        try {
//        	list = companyDao.select(idHotel, roomStatus);
//
//        } catch (Exception e){
//        	e.printStackTrace();
//        	throw new Exception();
//        }

        return list;
    }

}