package br.com.principal.controller;

import br.com.principal.StarterApplication;
import br.com.principal.dto.SecaoDisponivelArmazenamentoDTO;
import br.com.principal.dto.SecaoDisponivelVendaDTO;
import br.com.principal.service.SecaoService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/api/secoes/")
public class SecaoController {

    // Consulta das seções disponíveis de armazenamento de um determinado volume
    @GetMapping("disponivel_armazenamento")
    public List<SecaoDisponivelArmazenamentoDTO> buscarSecoesDisponiveisParaArmazenamento() {
        ApplicationContext ctx = StarterApplication.getContext();
        SecaoService secaoService = ctx.getBean(SecaoService.class);
        
        return secaoService.buscarSecoesDisponiveisArmazenamento();
    }
    
    //Consulta das seções disponíveis para venda de determinado tipo de bebida 
    @GetMapping("disponivel_venda")
    public List<SecaoDisponivelVendaDTO> buscarSecoesDisponiveisParaVenda() {
        ApplicationContext ctx = StarterApplication.getContext();
        SecaoService secaoService = ctx.getBean(SecaoService.class);
        
        return secaoService.buscarSecoesDisponiveisVenda();
    }
}
