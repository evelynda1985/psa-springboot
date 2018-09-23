package org.parentsstepahead.psa.dao;




import org.parentsstepahead.psa.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CountryDao extends CrudRepository<Country, Long> {

    List<Country> findAllByOrderByCountryName();
}