package br.com.itau.Pocovid.service.impl;

import br.com.itau.Pocovid.model.StateDto;
import br.com.itau.Pocovid.repository.StatesRepository;
import br.com.itau.Pocovid.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StatesRepository statesRepository;


    public List<StateDto> getStateList() {

       return StateDto.converter(statesRepository.findAll());
    }

    public StateDto getStateByUfAndDate(String datetime , String uf) {
        return statesRepository.findByUfAndDatetime(datetime, uf);
    }

}
