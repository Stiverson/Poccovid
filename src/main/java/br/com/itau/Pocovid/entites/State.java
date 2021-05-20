package br.com.itau.Pocovid.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "State")
public class State {

    @Column
    private Integer uid;
    @Column
    private String uf;
    @Column
    private String state;
    @Column
    private Integer cases;
    @Column
    private Integer deaths;
    @Column
    private Integer suspects;
    @Column
    private Integer refuses;
    @Column
    private String datetime;
}
