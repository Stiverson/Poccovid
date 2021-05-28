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

    public RequestDto(String email, String country, String data, String uf) {
        this.email = email;
        this.country = country;
        this.data = data;
        this.uf = uf;

    }

    public RequestDto(String email, String country, String data) {
        this.email = email;
        this.country = country;
        this.data = data;
    }
}
