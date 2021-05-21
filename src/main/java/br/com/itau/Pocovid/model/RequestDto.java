package br.com.itau.Pocovid.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {

    private String email;
    private String data;
    private String uf;
    private String country;
}
