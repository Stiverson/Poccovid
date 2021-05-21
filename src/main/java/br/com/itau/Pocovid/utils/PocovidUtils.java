package br.com.itau.Pocovid.utils;


import br.com.itau.Pocovid.model.RequestDto;


public class PocovidUtils {

    public boolean validarParametros(RequestDto requestDto) throws Exception {

        if (requestDto.getCountry() ==  null || requestDto.getCountry() == ""){
            throw  new Exception("E necessario  inserir o Pais");
        }
        if (requestDto.getData() == null || requestDto.getData() == ""){
            throw new Exception("E necessario  inserir a Data");
        }
        if (requestDto.getEmail() == null || requestDto.getEmail() == ""){
           throw  new Exception("E necessario  inserir o e-mail");
        }

        return true;
    }
}
