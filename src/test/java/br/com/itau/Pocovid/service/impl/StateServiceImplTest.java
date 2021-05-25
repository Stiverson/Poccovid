package br.com.itau.Pocovid.service.impl;


import br.com.itau.Pocovid.entites.State;
import br.com.itau.Pocovid.model.StateDto;
import br.com.itau.Pocovid.repository.StatesRepository;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class StateServiceImplTest {

    @InjectMocks
    StateServiceImpl stateService;

    @Mock
    StatesRepository statesRepository;

    @Test
    public void getStateList() {
    }

    @DisplayName("verifica que o getStateByUfAndDate retorna o StateDto convertido")
    @Test
    public void shouldReturnConvertedStateDto() {
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
}