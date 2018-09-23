package org.parentsstepahead.psa.service;

import java.util.ArrayList;
import java.util.List;


import org.parentsstepahead.psa.dao.CountryDao;
import org.parentsstepahead.psa.dao.ParentDao;
import org.parentsstepahead.psa.entity.Country;
import org.parentsstepahead.psa.entity.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParentServiceImplementation implements ParentService {
	
	@Autowired
	private ParentDao parentDao;
	
	@Autowired
	private CountryDao countryDao;


	@Override
	@Transactional 
	public List<Parent> getParents() {
		return (List<Parent> ) parentDao.findAll();
	}

	@Override
	@Transactional
	public void saveParent(Parent theParent) {
		parentDao.save(theParent);
		
	}

	@Override
	@Transactional
	public Parent getParent(int theId)
	{
		return parentDao.findById(Long.valueOf(theId)).get();
	}

	@Override
	@Transactional
	public void deleteParent(int theId) {


		this.parentDao.delete(this.parentDao.findById(Long.valueOf(theId)).get());

	}

	@Override
	@Transactional
	public List<Parent> searchParents(String theSearchName) {

		return this.parentDao.findByFirstNameOrderByLastName(theSearchName);


	}

	@Override
	@Transactional
	public ArrayList<String> getIncomeOptions() {

		Parent parent = new Parent();
		ArrayList<String> incomeOptions = parent.getIncomeOptions();
		return incomeOptions;

	}

	@Override
	@Transactional
	public List<Country> getCountry()
	{

		return (List<Country>) this.countryDao.findAllByOrderByCountryName();
	}
	
	

}
