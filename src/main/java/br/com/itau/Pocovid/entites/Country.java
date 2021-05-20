package br.com.itau.Pocovid.entites;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String country;
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
