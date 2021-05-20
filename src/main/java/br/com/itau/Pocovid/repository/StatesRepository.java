package br.com.itau.Pocovid.repository;

import br.com.itau.Pocovid.entites.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatesRepository extends JpaRepository<State, Long> {
}
