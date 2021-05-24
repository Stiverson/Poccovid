package br.com.itau.Pocovid.model;


import br.com.itau.Pocovid.entites.State;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

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

    public  StateDto(){

    }
    public StateDto(State state) {
        this.uf = state.getUf();
        this.state = state.getState();
        this.cases = state.getCases();
        this.deaths = state.getDeaths();
        this.suspects = state.getSuspects();
        this.refuses = state.getRefuses();
        this.datetime = state.getDatetime();
    }

    public StateDto(StateDto state) {
        this.uf = state.getUf();
        this.state = state.getState();
        this.cases = state.getCases();
        this.deaths = state.getDeaths();
        this.suspects = state.getSuspects();
        this.refuses = state.getRefuses();
        this.datetime = state.getDatetime();
    }

    public static List<StateDto> converter(List<State> state) {
        return state.stream().map(StateDto::new).collect(Collectors.toList());
    }
}
