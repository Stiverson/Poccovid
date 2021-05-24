package br.com.itau.Pocovid.controller;


import br.com.itau.Pocovid.model.RequestDto;
import br.com.itau.Pocovid.model.StateDto;
import br.com.itau.Pocovid.service.PocovidService;
import br.com.itau.Pocovid.utils.PocovidUtils;
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

    @GetMapping(value = "/states")
    public StateDto getStateByUfAndDate(@RequestBody RequestDto requestDto) throws Exception {

        if(PocovidUtils.validarParametros(requestDto)){

            return pocovidService.getStateByUfAndDate(requestDto.getData(),requestDto.getUf());

        }

        return null;
    }
}
