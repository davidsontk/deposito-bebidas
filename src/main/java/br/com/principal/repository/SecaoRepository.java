package br.com.principal.repository;

import br.com.principal.model.Secao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davidson ferreira
 */
@Repository
public interface SecaoRepository extends JpaRepository<Secao, Long> {

}
