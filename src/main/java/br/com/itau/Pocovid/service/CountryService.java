package br.com.itau.Pocovid.service;

import br.com.itau.Pocovid.model.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> getCountryList();

    CountryDto getCountryByCountry(String country);
}
