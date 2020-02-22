package br.com.principal.repository;

import br.com.principal.dto.HistoricoDTO;
import br.com.principal.model.Historico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davidson ferreira
 */
@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {

    @Query("SELECT new br.com.principal.dto.HistoricoDTO(h) "
            + " FROM Historico h "
            + " ORDER BY h.dataHora DESC")
    List<HistoricoDTO> buscarHistoricoPorData();

    @Query("SELECT new br.com.principal.dto.HistoricoDTO(h) "
            + " FROM Historico h "
            + " ORDER BY h.secaoId.codigo")
    List<HistoricoDTO> buscarHistoricoPorSecao();

}
