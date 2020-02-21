package br.com.principal.service;

import br.com.principal.dto.SecaoDisponivelArmazenamento;
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
    
    public List<SecaoDisponivelArmazenamento> buscarSecoesDisponiveisArmazenamento() {
        List<SecaoDisponivelArmazenamento> listaSecoes = new ArrayList<SecaoDisponivelArmazenamento>();
        List<Secao> secoes = secaoRepository.findAll();
        List<TipoBebida> tipoBebidaList = tipoBebidaRepository.findAll();
        for (Secao secao : secoes) {
            SecaoDisponivelArmazenamento secaoDisponivel = new SecaoDisponivelArmazenamento();
            Integer totalLitrosSecao = 0;
            List<Bebida> bebidas = bebidaRepository.findBySecaoId(secao);
            
            for (Bebida bebida : bebidas) {
                totalLitrosSecao = +bebida.getQuantidadeLitros();
            }
            
            secaoDisponivel.setCodigoSecao(secao.getCodigo());
            secaoDisponivel.setQuantidadeLitrosDisponivel(totalLitrosSecao);
            secaoDisponivel.setTipoBebida(secao.getTipoBebidaId() != null ? secao.getTipoBebidaId().getTipo() : "Nenhuma bebida cadastrada");
            
            listaSecoes.add(secaoDisponivel);
            
        }
        
        for (SecaoDisponivelArmazenamento secao : listaSecoes) {
            
            for (TipoBebida tipoBebida : tipoBebidaList) {
                if (tipoBebida.getTipo().equals(secao.getTipoBebida())) {
                    secao.setQuantidadeLitrosDisponivel(tipoBebida.getQuantidadeLitros() - secao.getQuantidadeLitrosDisponivel());
                }
            }
        }
        
        return listaSecoes;
        
    }
}
