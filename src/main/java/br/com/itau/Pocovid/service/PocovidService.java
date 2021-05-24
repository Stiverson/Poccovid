package br.com.itau.Pocovid.service;

import br.com.itau.Pocovid.model.CountryDto;
import br.com.itau.Pocovid.model.StateDto;
import br.com.itau.Pocovid.repository.CountryRepository;
import br.com.itau.Pocovid.repository.StatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PocovidService {

    @Autowired
    private StatesRepository statesRepository;

    @Autowired
    private CountryRepository countryRepository;

    public List<StateDto> getStateList() {

       return StateDto.converter(statesRepository.findAll());
    }

    public List<CountryDto> getCountryList() {
        return CountryDto.converter(countryRepository.findAll());
    }


    public StateDto getStateByUfAndDate(String datetime , String uf) {
        return statesRepository.findByUfAndDatetime(datetime, uf);
    }
}
