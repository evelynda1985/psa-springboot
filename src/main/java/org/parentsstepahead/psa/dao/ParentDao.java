package org.parentsstepahead.psa.dao;

import org.parentsstepahead.psa.entity.Country;
import org.parentsstepahead.psa.entity.Parent;

import java.util.ArrayList;
import java.util.List;


import org.parentsstepahead.psa.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParentDao extends CrudRepository<Parent, Long> {

	Country findBycountryName(String countryAbb);


	List<Parent> findByFirstNameOrderByLastName(String name);
}

