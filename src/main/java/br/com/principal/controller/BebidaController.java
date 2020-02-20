package br.com.principal.controller;

import br.com.principal.StarterApplication;
import br.com.principal.model.Secao;
import br.com.principal.model.TipoBebida;
import br.com.principal.repository.BebidaRepository;
import br.com.principal.repository.SecaoRepository;
import br.com.principal.repository.TipoBebidaRepository;
import br.com.principal.service.BebidaService;
import br.com.principal.utils.enums.TipoBebidaEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author davidson ferreira
 */
@Controller
@RequestMapping("/api/bebidas")
public class BebidaController {

    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private TipoBebidaRepository tipoBebidaRepository;

    @Autowired
    private SecaoRepository secaoRepository;

    public HttpStatus cadastrarBebidas(@PathVariable String tipoBebida, @PathVariable Integer quantidadeLitros, @PathVariable Integer codigoSecao) {
        ApplicationContext ctx = StarterApplication.getContext();
        BebidaService bebidaService = ctx.getBean(BebidaService.class);
        
        bebidaService.cadastrarBebida(tipoBebida, quantidadeLitros, codigoSecao);
        

        return HttpStatus.OK;
    }

}
