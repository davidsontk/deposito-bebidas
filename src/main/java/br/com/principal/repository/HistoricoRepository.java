package br.com.principal.repository;

import br.com.principal.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davidson ferreira
 */
@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

}
