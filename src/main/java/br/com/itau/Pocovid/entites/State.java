package br.com.itau.Pocovid.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "State")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
