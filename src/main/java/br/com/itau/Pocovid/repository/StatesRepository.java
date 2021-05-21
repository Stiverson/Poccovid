package br.com.itau.Pocovid.repository;

import br.com.itau.Pocovid.entites.State;
import br.com.itau.Pocovid.model.StateDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatesRepository extends JpaRepository<State, Long> {

    public StateDto findStateByUfAndDate(String uf);
}
