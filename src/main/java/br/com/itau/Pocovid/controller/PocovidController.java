package br.com.itau.Pocovid.controller;


import br.com.itau.Pocovid.model.BaseResponse;
import br.com.itau.Pocovid.model.RequestDto;
import br.com.itau.Pocovid.model.StateDto;
import br.com.itau.Pocovid.service.PocovidService;
import br.com.itau.Pocovid.utils.PocovidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "pocovid")
public class PocovidController {

    @Autowired
    PocovidService pocovidService;


    @GetMapping
    public List<StateDto> getStateList() {
        return pocovidService.getStateList();
    }

    @GetMapping(value = "/states")
    public ResponseEntity<BaseResponse> getStateByUfAndDate(@RequestBody RequestDto requestDto){

        if (PocovidUtils.validarParametros(requestDto)) {
            final StateDto stateDto =
                    new StateDto(pocovidService.getStateByUfAndDate(requestDto.getUf(), requestDto.getData()));
            return ResponseEntity.ok(BaseResponse.ok(stateDto));
        }
        return ResponseEntity.ok(BaseResponse.ok(new StateDto()));
    }
}
