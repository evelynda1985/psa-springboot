package org.parentsstepahead.psa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCountry")
	private int idCountry;
	
	@Column(name="countryAbb")
	private String countryAbb;
	
	@Column(name="countryName")
	private String countryName;

	public Country() {}

	public int getIdCountry() {
		return idCountry;
	}

	public String getCountryAbb() {
		return countryAbb;
	}

	public String getCountryName() {
		return countryName;
	}

	@Override
	public String toString() {
		return "Country [idCountry=" + idCountry + ", countryAbb=" + countryAbb + ", countryName=" + countryName + "]";
	}
	
	
	
	

}
