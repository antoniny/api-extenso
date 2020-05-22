package br.org.certi.apiextenso.repository;

import br.org.certi.apiextenso.model.UnidadeDezena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnidadeDezenaRepository extends JpaRepository<UnidadeDezena, Long> {

    @Query("SELECT u FROM unit_ten u WHERE ?1 between u.rangeMin and u.rangeMax ")
    Optional<UnidadeDezena> findByParameterBetweenRangeMinAndRangeMax(Double number);

}
