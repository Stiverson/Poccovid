package br.com.itau.Pocovid.controller;


import br.com.itau.Pocovid.model.BaseResponse;
import br.com.itau.Pocovid.model.CountryDto;
import br.com.itau.Pocovid.model.RequestDto;
import br.com.itau.Pocovid.model.StateDto;
import br.com.itau.Pocovid.service.CountryService;
import br.com.itau.Pocovid.service.StateService;
import br.com.itau.Pocovid.utils.PocovidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "pocovid")
public class PocovidController {

    @Autowired
    StateService stateService;

    @Autowired
    CountryService countryService;

    @GetMapping(value = "/states")
    public ResponseEntity<BaseResponse> getStateList() {
        final List<StateDto> stateList = new ArrayList<>(stateService.getStateList());
        return ResponseEntity.ok(BaseResponse.ok(stateList));
    }

    @GetMapping(value = "/state")
    public ResponseEntity<BaseResponse> getStateByUfAndDate(@RequestBody RequestDto requestDto){

        if (PocovidUtils.validarParametros(requestDto)) {
            final StateDto stateDto =
                    new StateDto(stateService.getStateByUfAndDate(requestDto.getUf(), requestDto.getData()));
            return ResponseEntity.ok(BaseResponse.ok(stateDto));
        }
        return ResponseEntity.ok(BaseResponse.ok(new StateDto()));
    }

    @GetMapping(value = "/countries")
    public ResponseEntity<BaseResponse> getCountryList(){
            final List<CountryDto> countryList = new ArrayList<>(countryService.getCountryList());
            return ResponseEntity.ok(BaseResponse.ok(countryList));
    }


    @GetMapping(value = "/country")
    public ResponseEntity<BaseResponse> getCountryByCountry(@RequestBody RequestDto requestDto){
        if (PocovidUtils.validarParametros(requestDto)) {
            final CountryDto countryDto =
                    new CountryDto(countryService.getCountryByCountry(requestDto.getCountry()));
            return ResponseEntity.ok(BaseResponse.ok(countryDto));
        }
        return ResponseEntity.ok(BaseResponse.ok(new CountryDto()));
    }
}
