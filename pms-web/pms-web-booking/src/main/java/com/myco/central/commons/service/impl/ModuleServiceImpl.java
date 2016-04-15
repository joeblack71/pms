
package com.myco.central.commons.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myco.central.commons.dao.CityDao;
import com.myco.central.commons.dao.CountryDao;
import com.myco.central.commons.dao.HotelDao;
import com.myco.central.commons.dao.SegmentDao;
import com.myco.central.commons.dao.SourceTypeDao;
import com.myco.central.commons.dao.DataCatalogDao;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.City;
import com.myco.central.commons.model.Country;
import com.myco.central.commons.model.DataCatalog;
import com.myco.central.commons.model.Hotel;
import com.myco.central.commons.model.Segment;
import com.myco.central.commons.model.SourceType;
import com.myco.central.commons.service.ModuleService;
import com.myco.central.constants.CentralModuleConstants;
import com.myco.central.reservations.dao.SpecialRateDao;
import com.myco.central.util.ContextAttributes;

public class ModuleServiceImpl extends GenericServiceImpl implements ModuleService {
	
	private CountryDao countryDao;
	private CityDao cityDao;
	private DataCatalogDao dataCatalogDao;
	private HotelDao hotelDao;
	private SourceTypeDao sourceTypeDao;
	private SegmentDao segmentDao;
	private SpecialRateDao specialRateDao;
	
	public ModuleServiceImpl() {
    }

    public ContextAttributes getContextAttributes() throws ServiceException {
    	ContextAttributes ca = new ContextAttributes();

		Country country = new Country();
		City city = new City();
		Hotel hotel = new Hotel();
		SourceType sourceTypeFilter = new SourceType();
		Segment segmentFilter = new Segment();

		DataCatalog dataCatalog = new DataCatalog();

		Map<String, Object> filter = new HashMap<String, Object>();

		try {
    		ca.setCities( cityDao.select(city) );
    		ca.setCountries( countryDao.select(country) );

    		dataCatalog.setIdCatalog(CentralModuleConstants.TABLE_DOCUMENT_TYPES);
    		dataCatalog.setIdDataCatalog("idItem");
			ca.setDocumentTypes( dataCatalogDao.select(filter) );

    		dataCatalog.setIdCatalog(CentralModuleConstants.TABLE_TITLES);
    		dataCatalog.setIdDataCatalog("idItem");
			ca.setTitles( dataCatalogDao.select(filter) );

			dataCatalog.setIdCatalog(CentralModuleConstants.TABLE_STREET_TYPES);
    		dataCatalog.setIdDataCatalog("idItem");
			ca.setStreetTypes( dataCatalogDao.select(filter) );

			ca.setVipStatusselect( getVipStatus() );
			ca.setCategories( getCategories() );
			
			dataCatalog.setIdCatalog("1");
    		dataCatalog.setIdDataCatalog("idItem");
			//ca.setQueryReservationsFields( tableItemDao.select(filter) ); // TODO

    		ca.setHotels(hotelDao.select(hotel));

    		sourceTypeFilter.setStatus("A");
			ca.setSourceTypes(sourceTypeDao.select(sourceTypeFilter) );

			segmentFilter.setIdHotel("01");
			ca.setSegments( segmentDao.select(segmentFilter) );

			ca.setSpecialRates( specialRateDao.select("1", "", "") );

			//ca.setPeriods() // TODO
    		//ca.setMonths() // TODO
    		//ca.setAmmountSales() // TODO
    	} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}

		return ca;
    }

    ////////////////////
    /// Private interface
    ////////////////////
    
    // FIXME testing with enum
    private List<Map<String, Object>> getVipStatus() {
    	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    	
    	Map<String, Object> bean = new HashMap<String, Object>();
    	bean.put("label","V1");
    	bean.put("value","1");

    	list.add(bean);

    	return list;
    }

    private List<Map<String, Object>> getCategories() {
    	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    	
    	Map<String, Object> bean = new HashMap<String, Object>();
    	bean.put("label","A");
    	bean.put("value","A");
    	list.add(bean);

    	bean = new HashMap<String, Object>();
    	bean.put("label","B");
    	bean.put("value","B");
    	list.add(bean);

    	bean = new HashMap<String, Object>();
    	bean.put("label","O");
    	bean.put("value","OTROS");
    	list.add(bean);

    	return list;
    }

    //////// Dependencies Injection

	public void setCountryDao(CountryDao countryDao) {
		this.countryDao = countryDao;
	}

	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	public void setTableItemDao(DataCatalogDao tableItemDao) {
		this.dataCatalogDao = tableItemDao;
	}

	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public void setSourceTypeDao(SourceTypeDao sourceTypeDao) {
		this.sourceTypeDao = sourceTypeDao;
	}

	public void setSegmentDao(SegmentDao segmentDao) {
		this.segmentDao = segmentDao;
	}

	public void setSpecialRateDao(SpecialRateDao specialRateDao) {
		this.specialRateDao = specialRateDao;
	}

}