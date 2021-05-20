package br.com.itau.Pocovid.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryDto {

    private String country;
    private Integer cases;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private String updated_at;
}
