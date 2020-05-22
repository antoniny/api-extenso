package br.org.certi.apiextenso.repository;

import br.org.certi.apiextenso.model.IdentificadorUnidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IdentificadorUnidadeRepository extends JpaRepository<IdentificadorUnidade, Long> {

    Optional<IdentificadorUnidade> findByRangeMinIsGreaterThanEqualAndRangeMaxLessThanEqual(int range_min, int range_max);

}
