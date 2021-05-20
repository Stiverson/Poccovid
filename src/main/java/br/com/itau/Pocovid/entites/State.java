package br.com.itau.Pocovid.entites;

import javax.persistence.*;


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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getSuspects() {
        return suspects;
    }

    public void setSuspects(Integer suspects) {
        this.suspects = suspects;
    }

    public Integer getRefuses() {
        return refuses;
    }

    public void setRefuses(Integer refuses) {
        this.refuses = refuses;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

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
