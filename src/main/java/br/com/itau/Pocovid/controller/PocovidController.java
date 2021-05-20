package br.com.itau.Pocovid.controller;

import br.com.itau.Pocovid.model.CountryDto;
import br.com.itau.Pocovid.model.StateDto;
import br.com.itau.Pocovid.service.PocovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "pocovid")
public class PocovidController {

    @Autowired
    PocovidService pocovidService;

    /**
     *
     * @return retorna uma lista de estados com casos de covid
     */

    @GetMapping
    public List<StateDto> getStateList() {

        return pocovidService.getStateList();
    }

    @GetMapping(value = "/states/{uf}")
    public StateDto getState(@PathVariable String uf) {
        return pocovidService.getStateByUf(uf);
    }
}
