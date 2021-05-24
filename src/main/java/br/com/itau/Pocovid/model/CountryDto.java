package br.com.itau.Pocovid.model;

import br.com.itau.Pocovid.entites.Country;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CountryDto {

    private String country;
    private Integer cases;
    private Integer confirmed;
    private Integer deaths;
    private Integer recovered;
    private String updated_at;

    public CountryDto(){

    }

    public CountryDto(Country country) {
        this.country = country.getCountry();
        this.cases = country.getCases();
        this.confirmed = country.getConfirmed();
        this.deaths = country.getDeaths();
        this.recovered = country.getRecovered();
        this.updated_at = getUpdated_at();
    }

    public CountryDto(CountryDto countryDto) {
        this.country = countryDto.getCountry();
        this.cases = countryDto.getCases();
        this.confirmed = countryDto.getConfirmed();
        this.deaths = countryDto.getDeaths();
        this.recovered = countryDto.getRecovered();
        this.updated_at = countryDto.getUpdated_at();
    }

    public static List<CountryDto> converter(List<Country> states) {
        return states.stream().map(CountryDto::new).collect(Collectors.toList());
    }
}
