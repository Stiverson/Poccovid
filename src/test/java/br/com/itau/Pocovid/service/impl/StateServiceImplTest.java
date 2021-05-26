package br.com.itau.Pocovid.service.impl;


import br.com.itau.Pocovid.entites.State;
import br.com.itau.Pocovid.model.StateDto;
import br.com.itau.Pocovid.repository.StatesRepository;
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
public class StateServiceImplTest {

    @InjectMocks
    StateServiceImpl stateService;

    @Mock
    StatesRepository statesRepository;

    @DisplayName("Testa se countryService.getStatesList retorna lista de states convertida pra Dto")
    @Test
    public void shouldReturnStateList() {
        List<State> stateList = new ArrayList<>();


        State spyOne = new State();
        State spyTwo = new State();
        spyOne.setUf("SP");
        spyTwo.setUf("RJ");
        stateList.add(spyOne);
        stateList.add(spyTwo);

        List<StateDto> expectedListDto;
        expectedListDto = StateDto.converter(stateList);

        when(statesRepository.findAll()).thenReturn(stateList);

        List<StateDto> resultDto = stateService.getStateList();

        assertEquals(expectedListDto.get(0).getUf(), resultDto.get(0).getUf());
        assertEquals(expectedListDto.get(0).getUf(), resultDto.get(0).getUf());

        verify(statesRepository).findAll();
    }

    @DisplayName("verifica que o getStateByUfAndDate retorna o StateDto convertido")
    @Test
    public void shouldReturnConvertedStateDtoTest() {
        State state = mock(State.class);
        state.setUf("SP");
        state.setDatetime("2020-03-21T23:43:02.000Z");

        StateDto expectedDto = new StateDto(state);

        when(statesRepository.findByUfAndDatetime(any(), any())).thenReturn(state);

        StateDto resultDto = stateService.getStateByUfAndDate("2020-03-21T23:43:02.000Z", "SP");

        assertEquals(resultDto.getDatetime(), expectedDto.getDatetime());
        assertEquals(resultDto.getUf(), expectedDto.getUf());

        verify(statesRepository).findByUfAndDatetime("2020-03-21T23:43:02.000Z", "SP");
    }

    @Test
    public void shouldReturnNullWhenStateDoesntExist() {
        State state = mock(State.class);
        state.setUf("SP");
        state.setDatetime("2020-03-21T23:43:02.000Z");

        when(statesRepository.findByUfAndDatetime(any(), any())).thenReturn(state);

        StateDto resultDto = stateService.getStateByUfAndDate("2020-03-21T27:43:02.000Z", "RJ");

        assertNull(resultDto.getDatetime());
        assertNull(resultDto.getUf());

        verify(statesRepository).findByUfAndDatetime(anyString(), anyString());
    }
}