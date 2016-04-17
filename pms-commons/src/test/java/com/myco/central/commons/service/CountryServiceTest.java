package com.myco.central.commons.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.myco.central.commons.model.Country;

import junit.framework.TestCase;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"persistence.xml","pms-commons-service-test.xml"})
public class CountryServiceTest extends TestCase {
	private static Long idCountry;

	@Autowired
    private CountryService countryService;

    public CountryServiceTest(String name) {
        super(name);
    }

    private Country getFilter() {
        Country country = new Country();

//        country.setName("Argentina");
        country.setDescription("Argentina");
        country.setAbbreviation("AR");
        country.setNationality("Argentinian");

        return country;
    }

    private Country getCountry() {
		Country country = new Country();
		return country;
	}

    @Test
    public void remove() {
        try {
            countryService.remove(new Long(1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		//TODO add assertions
    }

    @Test
    public void findById() {
        Country country = null;
		try {
            country = countryService.get(new Long(1));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        assertNotNull("*** No se recupero registro ***", country);
    }

    @Test
    public void saveCountry() {

    	try {
            countryService.save(getCountry());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        assertNotNull("*** No se inserto registro ***", idCountry);
    }

    @Test
    public void searchCountries() {
		List<Country> list = null;
		try {
			list = countryService.search(getFilter());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

        assertNotNull("*** No se recuperaron registros ***", list);
    }

	/*public void testUpdateCountry() {
        Country country = getCountry();
        boolean result = false;

        try {
            country.setId(idCountry);
            countryService.update(country);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        assertNotNull("*** No se inserto registro ***", result);
    }*/

}
