package br.com.principal.repository;

import br.com.principal.model.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davidson ferreira
 */
@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long> {

}
