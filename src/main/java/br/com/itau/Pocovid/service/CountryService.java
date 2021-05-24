package br.com.itau.Pocovid.service;

import br.com.itau.Pocovid.model.CountryDto;
import br.com.itau.Pocovid.model.StateDto;
import br.com.itau.Pocovid.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<CountryDto> getCountryList() {
        return CountryDto.converter(countryRepository.findAll());
    }

    public StateDto getCountryByCountry(String country){
        return  countryRepository.findByCountry(country);

    }

}
