package br.com.itau.Pocovid.repository;

import br.com.itau.Pocovid.entites.State;
import br.com.itau.Pocovid.model.StateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StatesRepository extends JpaRepository<State, Long> {

    public StateDto findByUfAndDatetime(String uf, String datetime);
}
