package br.com.itau.Pocovid.repository;
import br.com.itau.Pocovid.entites.Country;
import br.com.itau.Pocovid.model.CountryDto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, Long> {

    public Country findByCountry(String country);

}
