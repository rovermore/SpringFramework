package com.bolsadeideas.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.app.models.domain.Country;

@Service
public class CountryServiceImpl implements CountryService {
	
	private List<Country> countryList;
	
	public CountryServiceImpl() {
		countryList = new ArrayList<Country>();
		countryList.add(new Country(1,"ES", "Spain"));
		countryList.add(new Country(2,"FR", "France"));
		countryList.add(new Country(3,"PT", "Portugal"));
		countryList.add(new Country(4,"DE", "Germany"));
		countryList.add(new Country(5,"IT", "Italy"));
		countryList.add(new Country(6,"GB", "Great Britain"));
	}

	@Override
	public List<Country> getCountryList() {
		return countryList;
	}

	@Override
	public Country getCountryById(Integer id) {
		Country  result = null;
		for (Country country : countryList) {
			if (country.getId() == id)
			result = country;
		}
		return result;
	}
}
