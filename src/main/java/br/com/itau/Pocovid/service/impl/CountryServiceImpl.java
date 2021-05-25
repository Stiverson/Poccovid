package br.com.itau.Pocovid.service.impl;

import br.com.itau.Pocovid.model.CountryDto;
import br.com.itau.Pocovid.repository.CountryRepository;
import br.com.itau.Pocovid.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<CountryDto> getCountryList() {
        return CountryDto.converter(countryRepository.findAll());
    }

    public CountryDto getCountryByCountry(String country){
        return countryRepository.findByCountry(country);

    }

}
