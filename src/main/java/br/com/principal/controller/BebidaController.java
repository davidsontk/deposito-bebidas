package br.com.principal.controller;

import br.com.principal.model.Secao;
import br.com.principal.model.TipoBebida;
import br.com.principal.repository.BebidaRepository;
import br.com.principal.repository.SecaoRepository;
import br.com.principal.repository.TipoBebidaRepository;
import br.com.principal.utils.enums.TipoBebidaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author davidson ferreira
 */
@Controller
@RequestMapping("/api")
public class BebidaController {

    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private TipoBebidaRepository tipoBebidaRepository;

    @Autowired
    private SecaoRepository secaoRepository;

    public HttpStatus cadastrarBebidas(@PathVariable String tipoBebida, @PathVariable Integer quantidadeLitros, @PathVariable Integer codigoSecao) {
        TipoBebida tipoBebidaSelecionada;
        Secao secao;
        //para saber o tipo da bebida a quantidade que cada secao suporta
        if (tipoBebida.equals(TipoBebidaEnum.ALCOOLICO.name())) {
            tipoBebidaSelecionada = tipoBebidaRepository.findByTipo(TipoBebidaEnum.ALCOOLICO.name());
        } else if (tipoBebida.equals(TipoBebidaEnum.NAO_ALCOOLICO.name())) {
            tipoBebidaSelecionada = tipoBebidaRepository.findByTipo(TipoBebidaEnum.ALCOOLICO.name());
        }
        
        secao = secaoRepository.findByCodigo(codigoSecao);
        
        

        return HttpStatus.OK;
    }

}
