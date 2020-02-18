package br.com.principal.repository;

import br.com.principal.model.TipoBebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davidson ferreira
 */
@Repository
public interface TipoBebidaRepository extends JpaRepository<TipoBebida, Long> {

    @Override
    TipoBebida save(TipoBebida tipoBebida);
    
    TipoBebida findByTipo (String tipoBebida);
}
