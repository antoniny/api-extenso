package br.org.certi.apiextenso.repository;

import br.org.certi.apiextenso.model.Dezena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DezenaRepository extends JpaRepository<Dezena, Long> {

   @Query("SELECT u FROM ten u WHERE ?1 between u.rangeMin and u.rangeMax ")
   Optional<Dezena> findByParameterBetweenRangeMinAndRangeMax(Double number);
}
