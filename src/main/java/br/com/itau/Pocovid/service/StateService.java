package br.com.itau.Pocovid.service;

import br.com.itau.Pocovid.model.StateDto;

import java.util.List;

public interface StateService {

    List<StateDto> getStateList();

    StateDto getStateByUfAndDate(String datetime , String uf);
}
