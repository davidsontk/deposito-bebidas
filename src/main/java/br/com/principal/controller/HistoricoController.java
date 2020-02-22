package br.com.principal.controller;

import br.com.principal.StarterApplication;
import br.com.principal.dto.HistoricoDTO;
import br.com.principal.repository.HistoricoRepository;
import br.com.principal.service.BebidaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/api/historico/")
public class HistoricoController {

    @Autowired
    HistoricoRepository historicoRepository;

    //Consulta do historico de entradas e saídas por tipo de bebida e secao.
    @GetMapping("lista_historico/{tipoOrdenacao}")
    public List<HistoricoDTO> buscarHistorico(@PathVariable String tipoOrdenacao) {

        if (tipoOrdenacao.equals("dataHora")) {
            return historicoRepository.buscarHistoricoPorData();
        } else {
            return historicoRepository.buscarHistoricoPorSecao();
        }
    }

}
