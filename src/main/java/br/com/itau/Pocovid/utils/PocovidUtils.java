package br.com.itau.Pocovid.utils;


import br.com.itau.Pocovid.exceptions.UtilsException;
import br.com.itau.Pocovid.model.RequestDto;

public class PocovidUtils {

    public static boolean validateParameters(RequestDto requestDto) throws UtilsException {

        if (requestDto.getCountry() ==  null || requestDto.getCountry() == ""){
            throw new UtilsException("E necessario  inserir o Pais");
        }
        if (requestDto.getData() == null || requestDto.getData() == ""){
            throw new UtilsException("E necessario  inserir a Data");
        }
        if (requestDto.getEmail() == null || requestDto.getEmail() == ""){
           throw new UtilsException("E necessario  inserir o e-mail");
        }

        return true;
    }
}
