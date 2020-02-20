package br.com.principal.service;

import br.com.principal.dto.SecaoReduzidaDTO;
import br.com.principal.model.Secao;
import br.com.principal.repository.BebidaRepository;
import br.com.principal.repository.HistoricoRepository;
import br.com.principal.repository.SecaoRepository;
import br.com.principal.repository.TipoBebidaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author davidson ferreira
 */
@Service
public class SecaoService {

    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private TipoBebidaRepository tipoBebidaRepository;

    @Autowired
    private SecaoRepository secaoRepository;

    @Autowired
    private HistoricoRepository historicoRepository;

    public List<SecaoReduzidaDTO> buscarSecoes() {
        return secaoRepository.buscarSecoes();
    }
}
