package br.org.certi.apiextenso.repository;

import br.org.certi.apiextenso.model.Centena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentenaRepository extends JpaRepository<Centena, Long> {

        @Query("SELECT u FROM hundred u WHERE ?1 between u.rangeMin and u.rangeMax ")
        Optional<Centena> findByParameterBetweenRangeMinAndRangeMax(Double number);
}
