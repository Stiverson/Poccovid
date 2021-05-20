package br.com.itau.Pocovid.model;

import br.com.itau.Pocovid.entites.Country;
import br.com.itau.Pocovid.entites.State;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

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

    public CountryDto(Country country) {
        this.country = country.getCountry();
        this.cases = country.getCases();
        this.confirmed = country.getConfirmed();
        this.deaths = country.getDeaths();
        this.recovered = country.getRecovered();
        this.updated_at = getUpdated_at();
    }

    public static List<CountryDto> converter(List<Country> states) {
        return states.stream().map(CountryDto::new).collect(Collectors.toList());
    }
}
