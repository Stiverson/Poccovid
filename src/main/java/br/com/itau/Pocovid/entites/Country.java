package br.com.itau.Pocovid.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "Country")
public class Country {
    @Column
    private String coutry;
    @Column
    private Integer cases;
    @Column
    private Integer confirmed;
    @Column
    private Integer deaths;
    @Column
    private Integer recovered;
    @Column
    private String updated_at;
}
