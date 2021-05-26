package br.com.itau.Pocovid.service.impl;

import br.com.itau.Pocovid.entites.Country;
import br.com.itau.Pocovid.model.CountryDto;
import br.com.itau.Pocovid.repository.CountryRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceImplTest {

    @InjectMocks
    CountryServiceImpl countryService;

    @Mock
    CountryRepository countryRepository;

    @DisplayName("Testa se countryService.getCountryList retorna lista de country convertida pra Dto")
    @Test
    public void shouldReturnCountryListConvertedToDtoTest() {
        List<Country> countryList = new ArrayList<>();


        Country spyOne = new Country();
        Country spyTwo = new Country();
        spyOne.setCountry("Canada");
        spyTwo.setCountry("Brazil");
        countryList.add(spyOne);
        countryList.add(spyTwo);

        List<CountryDto> expectedListDto;
        expectedListDto = CountryDto.converter(countryList);

        when(countryRepository.findAll()).thenReturn(countryList);

        List<CountryDto> resultDto = countryService.getCountryList();

        assertEquals(expectedListDto.get(0).getCountry(), resultDto.get(0).getCountry());
        assertEquals(expectedListDto.get(0).getCountry(), resultDto.get(0).getCountry());

        verify(countryRepository).findAll();



    }

    @DisplayName("testa se countryService.getCountryByCountry retorna a lista de paises por nome do pais")
    @Test
    public void shouldReturnCountryByCountryName() {
        Country country = mock(Country.class);
        country.setCountry("brazil");

        CountryDto expectedDto = new CountryDto(country);

        when(countryRepository.findByCountry(anyString())).thenReturn(country);

        CountryDto resultDto = countryService.getCountryByCountry("brazil");

        assertEquals(expectedDto.getCountry(), resultDto.getCountry());

        verify(countryRepository).findByCountry(anyString());
    }

    @DisplayName("deve retornar null quando país passado não existe")
    @Test
    public void shouldReturnNullWhenCountryDoesntExist() {
        Country country = mock(Country.class);
        country.setCountry("brazil");

        when(countryRepository.findByCountry(anyString())).thenReturn(country);

        CountryDto resultDto = countryService.getCountryByCountry("canada");

        assertNull(resultDto.getCountry());

        verify(countryRepository).findByCountry(anyString());
    }
}