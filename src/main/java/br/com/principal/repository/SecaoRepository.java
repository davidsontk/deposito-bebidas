package br.com.principal.repository;

import br.com.principal.dto.SecaoReduzidaDTO;
import br.com.principal.model.Secao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davidson ferreira
 */
@Repository
public interface SecaoRepository extends JpaRepository<Secao, Long> {

    @Override
    Secao save(Secao secao);

    Secao findByCodigo(Integer codigo);

    @Query("SELECT new br.com.principal.dto.SecaoReduzidaDTO(secao) "
            + " FROM Secao secao "
            + " ORDER BY secao.codigo")
    List<SecaoReduzidaDTO> buscarSecoes();
}
