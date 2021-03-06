package br.com.principal.service;

import br.com.principal.dto.SecaoDisponivelArmazenamentoDTO;
import br.com.principal.dto.SecaoDisponivelVendaDTO;
import br.com.principal.dto.SecaoReduzidaDTO;
import br.com.principal.model.Bebida;
import br.com.principal.model.Secao;
import br.com.principal.model.TipoBebida;
import br.com.principal.repository.BebidaRepository;
import br.com.principal.repository.HistoricoRepository;
import br.com.principal.repository.SecaoRepository;
import br.com.principal.repository.TipoBebidaRepository;
import java.util.ArrayList;
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

    public List<SecaoDisponivelArmazenamentoDTO> buscarSecoesDisponiveisArmazenamento() {
        List<SecaoDisponivelArmazenamentoDTO> listaSecoes = new ArrayList<SecaoDisponivelArmazenamentoDTO>();
        List<Secao> secoes = secaoRepository.findAll();
        List<TipoBebida> tipoBebidaList = tipoBebidaRepository.findAll();
        for (Secao secao : secoes) {
            SecaoDisponivelArmazenamentoDTO secaoDisponivel = new SecaoDisponivelArmazenamentoDTO();
            Integer totalLitrosSecao = 0;
            Bebida bebida = bebidaRepository.findBySecaoId(secao);
            if (bebida != null) {
                totalLitrosSecao = bebida.getQuantidadeLitros();

                secaoDisponivel.setCodigoSecao(secao.getCodigo());
                secaoDisponivel.setQuantidadeDisponivelArmazenamento(totalLitrosSecao);
                secaoDisponivel.setTipoBebida(secao.getTipoBebidaId() != null ? secao.getTipoBebidaId().getTipo() : "Nenhuma bebida cadastrada");

                listaSecoes.add(secaoDisponivel);
            } else {

                secaoDisponivel.setCodigoSecao(secao.getCodigo());
                secaoDisponivel.setQuantidadeDisponivelArmazenamento(null);
                secaoDisponivel.setTipoBebida("Nenhuma bebida cadastrada. Seção disponível");

                listaSecoes.add(secaoDisponivel);
            }

        }

        for (SecaoDisponivelArmazenamentoDTO secao : listaSecoes) {

            for (TipoBebida tipoBebida : tipoBebidaList) {
                if (tipoBebida.getTipo().equals(secao.getTipoBebida())) {
                    secao.setQuantidadeDisponivelArmazenamento(tipoBebida.getQuantidadeLitros() - secao.getQuantidadeDisponivelArmazenamento());
                }
            }
        }

        return listaSecoes;

    }

    public List<SecaoDisponivelVendaDTO> buscarSecoesDisponiveisVenda() {
        List<SecaoDisponivelVendaDTO> listaSecoes = new ArrayList<SecaoDisponivelVendaDTO>();
        List<Secao> secoes = secaoRepository.findAll();
        List<TipoBebida> tipoBebidaList = tipoBebidaRepository.findAll();
        for (Secao secao : secoes) {
            SecaoDisponivelVendaDTO secaoDisponivel = new SecaoDisponivelVendaDTO();
            Integer totalLitrosSecao = 0;
            Bebida bebida = bebidaRepository.findBySecaoId(secao);

            if (bebida != null) {
                totalLitrosSecao = bebida.getQuantidadeLitros();

                secaoDisponivel.setCodigoSecao(secao.getCodigo());
                secaoDisponivel.setQuantidadeDisponivelVenda(totalLitrosSecao);
                secaoDisponivel.setTipoBebida(secao.getTipoBebidaId() != null ? secao.getTipoBebidaId().getTipo() : "Nenhuma bebida cadastrada");
            }

            if (totalLitrosSecao != 0) {
                listaSecoes.add(secaoDisponivel);
            }

        }

        for (SecaoDisponivelVendaDTO secao : listaSecoes) {

            for (TipoBebida tipoBebida : tipoBebidaList) {
                if (tipoBebida.getTipo().equals(secao.getTipoBebida())) {
                    secao.setQuantidadeDisponivelVenda(secao.getQuantidadeDisponivelVenda());
                }
            }
        }

        return listaSecoes;
    }
}
