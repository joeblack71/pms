
package com.myco.central.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.dto.CountryDto;
import com.myco.central.commons.dto.DataCatalogDto;
import com.myco.central.commons.exceptions.ServiceException;
import com.myco.central.commons.model.City;
import com.myco.central.commons.service.CityService;
import com.myco.central.commons.service.CountryService;
import com.myco.central.commons.utils.PMSConstants;
import com.myco.central.core.service.HotelService;
import com.myco.central.core.service.SourceTypeService;
import com.myco.central.model.Hotel;
import com.myco.central.model.SourceType;

/* TODO Refactor */
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	private CountryService countryService;
	@Autowired
	private CityService cityService;
//	private DataCatalogService dataCatalogDao;
	private HotelService hotelService;
	private SourceTypeService sourceTypeService;
//	private GenericService<SourceType> sourceTypeService;

    public ContextAttributes getContextAttributes() throws ServiceException {
    	ContextAttributes ca = new ContextAttributes();

		CountryDto country = new CountryDto();
		City city = new City();
		Hotel hotel = new Hotel();
		SourceType sourceTypeFilter = new SourceType();
		DataCatalogDto dataCatalog = new DataCatalogDto();

		Map<String, Object> filter = new HashMap<String, Object>();

		try {
//    		ca.setCities( cityDao.search(city) );
//    		ca.setCountries( countryDao.search(country) );

    		dataCatalog.setIdCatalog(PMSConstants.TABLE_DOCUMENT_TYPES);
    		dataCatalog.setIdDataCatalog("idItem");
//			ca.setDocumentTypes(dataCatalogDao.select(filter));

    		dataCatalog.setIdCatalog(PMSConstants.TABLE_TITLES);
    		dataCatalog.setIdDataCatalog("idItem");
//			ca.setTitles( dataCatalogDao.select(filter) );

			dataCatalog.setIdCatalog(PMSConstants.TABLE_STREET_TYPES);
    		dataCatalog.setIdDataCatalog("idItem");
//			ca.setStreetTypes( dataCatalogDao.select(filter) );

			ca.setVipStatusselect( getVipStatus() );
			ca.setCategories( getCategories() );
			
			dataCatalog.setIdCatalog("1");
    		dataCatalog.setIdDataCatalog("idItem");
			//ca.setQueryReservationsFields( tableItemDao.select(filter) ); // TODO

    		// TODO implement mapper
//    		ca.setHotels(hotelService.getAll());

    		sourceTypeFilter.setStatus("A");
    		// TODO use mapper
//			ca.setSourceTypes(sourceTypeService.search(sourceTypeFilter) );

			// TODO create a search filter
//			segmentFilter.setIdHotel("01");
//			ca.setSegments( segmentDao.select(segmentFilter) );

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

}