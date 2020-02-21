package br.com.principal.controller;

import br.com.principal.StarterApplication;
import br.com.principal.dto.CadastroBebidaDTO;
import br.com.principal.dto.SecaoReduzidaDTO;
import br.com.principal.dto.TotalEstoqueDTO;

import br.com.principal.repository.BebidaRepository;
import br.com.principal.repository.SecaoRepository;
import br.com.principal.repository.TipoBebidaRepository;
import br.com.principal.service.BebidaService;
import br.com.principal.service.SecaoService;
import br.com.principal.utils.MensagemResposta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author davidson ferreira
 */
@RestController
@RequestMapping("/api/bebidas/")
public class BebidaController {

    @PostMapping("cadastrar_bebida")
    public MensagemResposta cadastrarBebidas(@RequestBody CadastroBebidaDTO cadastroBebida) {
        ApplicationContext ctx = StarterApplication.getContext();
        BebidaService bebidaService = ctx.getBean(BebidaService.class);

        return bebidaService.cadastrarBebida(cadastroBebida);
    }

    @GetMapping("secoes")
    public List<SecaoReduzidaDTO> buscarSecoes() {
        ApplicationContext ctx = StarterApplication.getContext();
        SecaoService secaoService = ctx.getBean(SecaoService.class);

        return secaoService.buscarSecoes();
    }

    @GetMapping("quantidade_total_bebidas")
    public List<TotalEstoqueDTO> buscarEstoqueTotalPorBebida(){
        ApplicationContext ctx = StarterApplication.getContext();
        BebidaService bebidaService = ctx.getBean(BebidaService.class);
        
        return bebidaService.buscarTotalEstoque();
    } 
}
