package br.com.itau.Pocovid.controller;

import br.com.itau.Pocovid.model.BaseResponse;
import br.com.itau.Pocovid.model.CountryDto;
import br.com.itau.Pocovid.model.RequestDto;
import br.com.itau.Pocovid.model.StateDto;
import br.com.itau.Pocovid.service.CountryService;
import br.com.itau.Pocovid.service.StateService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PocovidControllerTest {

    @InjectMocks
    PocovidController pocovidController;

    @Mock
    private StateService stateService;

    @Mock
    private CountryService countryService;

    @DisplayName("retorna lista de estados e status code 200")
    @Test
    public void shouldReturnListOfStatesDto()  {

        List<StateDto> stateDtos = new ArrayList<>();
        StateDto stateDto1 = new StateDto();
        stateDto1.setState("São Paulo");
        StateDto stateDto2 = new StateDto();
        stateDto2.setState("Rio de janeiro");
        stateDtos.add(stateDto1);
        stateDtos.add(stateDto2);

        when(stateService.getStateList()).thenReturn(stateDtos);

        ResponseEntity<BaseResponse> result = pocovidController.getStateList();

       assertEquals(stateDtos, Objects.requireNonNull(result.getBody()).getData());
       assertEquals(HttpStatus.OK, result.getStatusCode());

       Mockito.verify(stateService).getStateList();

    }

    @DisplayName("Retorna estado por uf e data e status code 200 quando requestDto está preenchido")
    @Test
    public void shouldReturnStateByUfAndDate() {
        RequestDto requestDto = new RequestDto();

        requestDto.setEmail("dsadsa@@dsdas");
        requestDto.setData("19/01");
        requestDto.setCountry("brazil");
        requestDto.setUf("SP");

        StateDto stateDto = new StateDto();
        stateDto.setUf("SP");

        when(stateService.getStateByUfAndDate(anyString(), anyString())).thenReturn(stateDto);

        ResponseEntity<BaseResponse> responseEntity = pocovidController.getStateByUfAndDate(requestDto);

        assertEquals(stateDto, Objects.requireNonNull(responseEntity.getBody()).getData());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        verify(stateService).getStateByUfAndDate(anyString(), anyString());
    }

    // TODO validar lógica do utils, talvez seja necessário mudar.

    /* @DisplayName("Não retorna estado por uf e data e status code 400 por requestDto não está preenchido")
    @Test
    public void shouldNotReturnStateByUfAndDate() {
        RequestDto requestDto = new RequestDto();

        requestDto.setData("19/01");
        requestDto.setCountry("brazil");
        requestDto.setUf("SP");

        StateDto stateDto = new StateDto();
        stateDto.setUf("SP");

        when(stateService.getStateByUfAndDate(anyString(), anyString())).thenReturn(stateDto);

        ResponseEntity<BaseResponse> responseEntity = pocovidController.getStateByUfAndDate(requestDto);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        verify(stateService, never()).getStateByUfAndDate(anyString(), anyString());
    } */

    @DisplayName("Valida se retorna lista de paises e statusCode 200")
    @Test
    public void shouldReturnListOfCountriesDto()  {

        List<CountryDto> countriesDto = new ArrayList<>();
        CountryDto countryDto1 = new CountryDto();
        countryDto1.setCountry("Brazil");
        CountryDto countryDto2 = new CountryDto();
        countryDto2.setCountry("Canada");
        countriesDto.add(countryDto1);
        countriesDto.add(countryDto2);

        when(countryService.getCountryList()).thenReturn(countriesDto);

        ResponseEntity<BaseResponse> result = pocovidController.getCountryList();

        assertEquals(countriesDto, Objects.requireNonNull(result.getBody()).getData());
        assertEquals(HttpStatus.OK, result.getStatusCode());

        Mockito.verify(countryService).getCountryList();

    }

    @Test
    public void shouldReturnCountryByCountryName() {
        RequestDto requestDto = new RequestDto();

        requestDto.setEmail("dsadsa@@dsdas");
        requestDto.setData("19/01");
        requestDto.setCountry("brazil");
        requestDto.setUf("SP");

        CountryDto countryDto = new CountryDto();
        countryDto.setCountry("brazil");

        when(countryService.getCountryByCountry(anyString())).thenReturn(countryDto);

        ResponseEntity<BaseResponse> responseEntity = pocovidController.getCountryByCountry(requestDto);

        assertEquals(countryDto, Objects.requireNonNull(responseEntity.getBody()).getData());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        verify(countryService).getCountryByCountry(anyString());
    }
}