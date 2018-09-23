package org.parentsstepahead.psa.dao;




import org.parentsstepahead.psa.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryDao extends CrudRepository<Country, String> {
    Country findBycountryNameOrderBycountryNameAsc(String countryAbb);
}