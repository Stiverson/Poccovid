package br.com.itau.Pocovid.controller;


import br.com.itau.Pocovid.model.BaseResponse;
import br.com.itau.Pocovid.model.CountryDto;
import br.com.itau.Pocovid.model.RequestDto;
import br.com.itau.Pocovid.model.StateDto;
import br.com.itau.Pocovid.service.CountryService;
import br.com.itau.Pocovid.service.StateService;
import br.com.itau.Pocovid.utils.PocovidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public StateDto getStateByUfAndDate(@RequestParam String email,
                                                            @RequestParam String country,
                                                            @RequestParam String data,
                                                            @RequestParam String uf) {

        if (PocovidUtils.validateParameters(new RequestDto(email, country, data, uf))) {
//            final StateDto stateDto =
//                        stateService.getStateByUfAndDate(uf,data);
//            return ResponseEntity.ok(BaseResponse.ok(stateDto));

            return  stateService.getStateByUfAndDate(uf,data);
        }

        return new StateDto();

    }

    @GetMapping(value = "/countries")
    public ResponseEntity<BaseResponse> getCountryList(){
            final List<CountryDto> countryList = new ArrayList<>(countryService.getCountryList());
            return ResponseEntity.ok(BaseResponse.ok(countryList));
    }


    @GetMapping(value = "/country")
    public CountryDto getCountryByCountry(@RequestParam String email,
                                                            @RequestParam String country,
                                                            @RequestParam String data){
        if (PocovidUtils.validateParameters(new RequestDto(email, country,data))) {
//            final CountryDto countryDto =
//                    countryService.getCountryByCountry(country);
//            return ResponseEntity.ok(BaseResponse.ok(countryDto));
            return countryService.getCountryByCountry(country);
        }
        return new CountryDto();
    }
}
