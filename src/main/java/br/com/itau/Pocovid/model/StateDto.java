package br.com.itau.Pocovid.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateDto {

    private Integer uid;
    private String uf;
    private String state;
    private Integer cases;
    private Integer deaths;
    private Integer suspects;
    private Integer refuses;
    private String datetime;
}
