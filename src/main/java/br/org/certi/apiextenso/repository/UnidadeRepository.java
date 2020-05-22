package br.org.certi.apiextenso.repository;

import br.org.certi.apiextenso.model.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

    @Query("SELECT u FROM unit u WHERE ?1 between u.rangeMin and u.rangeMax ")
    Optional<Unidade> findByParameterBetweenRangeMinAndRangeMax(Double number);

}
