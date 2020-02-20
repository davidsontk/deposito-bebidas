package br.com.principal.service;

import br.com.principal.dto.CadastroBebidaDTO;
import br.com.principal.model.Bebida;
import br.com.principal.model.Historico;
import br.com.principal.model.Secao;
import br.com.principal.model.TipoBebida;
import br.com.principal.repository.BebidaRepository;
import br.com.principal.repository.HistoricoRepository;
import br.com.principal.repository.SecaoRepository;
import br.com.principal.repository.TipoBebidaRepository;
import br.com.principal.utils.MensagemHistorico;
import br.com.principal.utils.MensagemResposta;
import br.com.principal.utils.enums.TipoBebidaEnum;
import java.util.Date;
import java.util.List;
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

    @Autowired
    private HistoricoRepository historicoRepository;

    public MensagemResposta cadastrarBebida(CadastroBebidaDTO cadastroBebidaDTO) {
        TipoBebida tipoBebidaSelecionada;
        Secao secao;
        Integer quantidadeTotalSecao = 0;
        MensagemResposta mensagemResposta = new MensagemResposta();

        //para saber o tipo da bebida a quantidade que cada secao suporta
        if (cadastroBebidaDTO.getTipoBebida().equals(TipoBebidaEnum.ALCOOLICA.name())) {
            tipoBebidaSelecionada = tipoBebidaRepository.findByTipo(TipoBebidaEnum.ALCOOLICA.name());
        } else {
            tipoBebidaSelecionada = tipoBebidaRepository.findByTipo(TipoBebidaEnum.ALCOOLICA.name());
        }

        secao = secaoRepository.findByCodigo(cadastroBebidaDTO.getCodigoSecao());

        if (secao == null) {
            mensagemResposta.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
            mensagemResposta.setMensagem("Código seção" + cadastroBebidaDTO.getCodigoSecao() + " não encontrado ");
            mensagemResposta.setStatusRequisicao(false);

            return mensagemResposta;
        }

        if (secao.getTipoBebidaId() == null || secao.getTipoBebidaId().getTipo().equals(tipoBebidaSelecionada.getTipo())) {

            List<Bebida> listaBebidas = bebidaRepository.findBySecaoId(secao);

            for (Bebida bebida : listaBebidas) {
                quantidadeTotalSecao += bebida.getQuantidadeLitros();
            }

            if (cadastroBebidaDTO.getQuantidadeLitros() <= tipoBebidaSelecionada.getQuantidadeLitros()) {
                Integer quantidadeLitrosAux = cadastroBebidaDTO.getQuantidadeLitros() + quantidadeTotalSecao;
                if (quantidadeLitrosAux <= tipoBebidaSelecionada.getQuantidadeLitros()) {
                    Bebida bebida = new Bebida();
                    bebida.setQuantidadeLitros(cadastroBebidaDTO.getQuantidadeLitros());
                    bebida.setSecaoId(secao);
                    bebida.setTipoBebidaId(tipoBebidaSelecionada);
                    bebidaRepository.save(bebida);

                    secao.setTipoBebidaId(tipoBebidaSelecionada);

                    secaoRepository.save(secao);

                    this.salvarHistorico(tipoBebidaSelecionada, secao, cadastroBebidaDTO.getNomeResponsavel(), cadastroBebidaDTO.getQuantidadeLitros(), MensagemHistorico.CADASTRO_BEBIDA);

                    mensagemResposta.setHttpStatus(HttpStatus.OK);
                    mensagemResposta.setMensagem("Bebida Cadastrada");
                    mensagemResposta.setStatusRequisicao(true);
                    return mensagemResposta;
                } else {
                    mensagemResposta.setHttpStatus(HttpStatus.OK);
                    mensagemResposta.setMensagem("Quantidade Invalida na seção: " + cadastroBebidaDTO.getCodigoSecao() + ". Quantidade em estoque " + quantidadeTotalSecao);
                    mensagemResposta.setStatusRequisicao(false);

                    return mensagemResposta;
                }

            } else {
                mensagemResposta.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
                mensagemResposta.setMensagem("Quantidade Invalida na seção: " + cadastroBebidaDTO.getCodigoSecao() + ". Quantidade em estoque " + quantidadeTotalSecao);
                mensagemResposta.setStatusRequisicao(false);

                return mensagemResposta;
            }
        } else {
            mensagemResposta.setHttpStatus(HttpStatus.BAD_REQUEST);
            mensagemResposta.setMensagem("Seção: " + cadastroBebidaDTO.getCodigoSecao() + " aceita apenas bebidas do tipo " + tipoBebidaSelecionada.getTipo());
            mensagemResposta.setStatusRequisicao(false);

            return mensagemResposta;
        }
    }

    //SALVANDO NO HISTORICO A ENTRADA E SAIDA DE BEBIDAS DO ESTOQUE
    public void salvarHistorico(TipoBebida tipoBebida, Secao secaoId, String nomeResponsavel, Integer quantidadesLitros, String tipo) {
        Historico historico = new Historico();
        historico.setDataHora(new Date());
        historico.setResponsavel(nomeResponsavel);
        historico.setSecaoId(secaoId);
        historico.setQuantidadeLitros(quantidadesLitros);
        historico.setTipoBebidaId(tipoBebida);
        historico.setTipo(tipo);
            
        historicoRepository.save(historico);
    }

}
