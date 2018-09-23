package org.parentsstepahead.psa.service;

import java.util.ArrayList;
import java.util.List;

import org.parentsstepahead.psa.entity.Country;
import org.parentsstepahead.psa.entity.Parent;

public interface ParentService {

	public List<Parent> getParents();

	public void saveParent(Parent theParent);

	public Parent getParent(int theId);

	public void deleteParent(int theId);

	public List<Parent> searchParents(String theSearchName);

	public ArrayList<String> getIncomeOptions();

	public List<Country> getCountry();
	
	

}
