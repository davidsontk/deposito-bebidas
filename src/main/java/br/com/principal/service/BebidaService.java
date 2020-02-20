package br.com.principal.service;

import br.com.principal.model.Secao;
import br.com.principal.model.TipoBebida;
import br.com.principal.repository.BebidaRepository;
import br.com.principal.repository.SecaoRepository;
import br.com.principal.repository.TipoBebidaRepository;
import br.com.principal.utils.enums.TipoBebidaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class BebidaService {
    
    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private TipoBebidaRepository tipoBebidaRepository;

    @Autowired
    private SecaoRepository secaoRepository;

    
    public HttpStatus cadastrarBebida(){
        TipoBebida tipoBebidaSelecionada;
        Secao secao;
        //para saber o tipo da bebida a quantidade que cada secao suporta
        if (tipoBebida.equals(TipoBebidaEnum.ALCOOLICO.name())) {
            tipoBebidaSelecionada = tipoBebidaRepository.findByTipo(TipoBebidaEnum.ALCOOLICO.name());
        } else if (tipoBebida.equals(TipoBebidaEnum.NAO_ALCOOLICO.name())) {
            tipoBebidaSelecionada = tipoBebidaRepository.findByTipo(TipoBebidaEnum.ALCOOLICO.name());
        }
        
        secao = secaoRepository.findByCodigo(codigoSecao);
        
    }
    
    
}
