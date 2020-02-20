package br.com.principal.repository;

import br.com.principal.model.Bebida;
import br.com.principal.model.Secao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davidson ferreira
 */
@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long> {

    @Override
    Bebida save(Bebida bebida);

    List<Bebida> findBySecaoId(Secao secaoId);
    
}
