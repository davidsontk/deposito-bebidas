package br.com.principal.controller;

import br.com.principal.StarterApplication;
import br.com.principal.dto.SecaoDisponivelArmazenamento;
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

    @GetMapping("disponivel_armazenamento")
    public List<SecaoDisponivelArmazenamento> buscarSecoesDisponiveisParaArmazenamento() {
        ApplicationContext ctx = StarterApplication.getContext();
        SecaoService secaoService = ctx.getBean(SecaoService.class);
        
        return secaoService.buscarSecoesDisponiveisArmazenamento();
    }
}
