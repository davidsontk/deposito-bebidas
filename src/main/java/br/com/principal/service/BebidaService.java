package br.com.principal.service;

import br.com.principal.dto.CadastroBebidaDTO;
import br.com.principal.dto.TotalEstoqueDTO;
import br.com.principal.dto.VendaDTO;
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
import java.util.ArrayList;
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
        tipoBebidaSelecionada = tipoBebidaRepository.findByTipo(cadastroBebidaDTO.getTipoBebida());

        if (tipoBebidaSelecionada == null) {
            mensagemResposta.setMensagem("Tipo Bebida " + cadastroBebidaDTO.getCodigoSecao() + " não encontrado ");
            mensagemResposta.setStatusRequisicao(false);

            return mensagemResposta;
        }

        secao = secaoRepository.findByCodigo(cadastroBebidaDTO.getCodigoSecao());

        if (secao == null) {
            mensagemResposta.setMensagem("Código seção" + cadastroBebidaDTO.getCodigoSecao() + " não encontrado ");
            mensagemResposta.setStatusRequisicao(false);

            return mensagemResposta;
        }

        if (secao.getTipoBebidaId() == null || secao.getTipoBebidaId().getTipo().equals(tipoBebidaSelecionada.getTipo())) {

            Bebida b = bebidaRepository.findBySecaoId(secao);

            if (b != null) {
                quantidadeTotalSecao = b.getQuantidadeLitros();

            }
            if (cadastroBebidaDTO.getQuantidadeLitros() <= tipoBebidaSelecionada.getQuantidadeLitros()) {
                Integer quantidadeLitrosAux = cadastroBebidaDTO.getQuantidadeLitros() + quantidadeTotalSecao;
                if (quantidadeLitrosAux <= tipoBebidaSelecionada.getQuantidadeLitros()) {

                    if (b == null) {
                        Bebida bebida = new Bebida();
                        bebida.setQuantidadeLitros(cadastroBebidaDTO.getQuantidadeLitros() + quantidadeTotalSecao);
                        bebida.setSecaoId(secao);
                        bebida.setTipoBebidaId(tipoBebidaSelecionada);
                        bebidaRepository.save(bebida);
                    } else {
                        b.setQuantidadeLitros(cadastroBebidaDTO.getQuantidadeLitros() + quantidadeTotalSecao);
                        bebidaRepository.save(b);
                    }

                    secao.setTipoBebidaId(tipoBebidaSelecionada);

                    secaoRepository.save(secao);

                    this.salvarHistorico(tipoBebidaSelecionada, secao, cadastroBebidaDTO.getNomeResponsavel(), cadastroBebidaDTO.getQuantidadeLitros(), MensagemHistorico.CADASTRO_BEBIDA);

                    mensagemResposta.setMensagem("Bebida Cadastrada");
                    mensagemResposta.setStatusRequisicao(true);
                    return mensagemResposta;
                } else {
                    mensagemResposta.setMensagem("Quantidade Invalida na seção: " + cadastroBebidaDTO.getCodigoSecao() + ". Quantidade em estoque " + quantidadeTotalSecao);
                    mensagemResposta.setStatusRequisicao(false);

                    return mensagemResposta;
                }

            } else {
                mensagemResposta.setMensagem("Quantidade Invalida na seção: " + cadastroBebidaDTO.getCodigoSecao() + ". Quantidade em estoque " + quantidadeTotalSecao);
                mensagemResposta.setStatusRequisicao(false);

                return mensagemResposta;
            }
        }
        mensagemResposta.setMensagem("Seção: " + cadastroBebidaDTO.getCodigoSecao() + " aceita apenas bebidas do tipo " + tipoBebidaSelecionada.getTipo());
        mensagemResposta.setStatusRequisicao(false);

        return mensagemResposta;
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

    //busca total estoques
    public List<TotalEstoqueDTO> buscarTotalEstoque() {
        List<TipoBebida> tipoBebidas = tipoBebidaRepository.findAll();
        List<Bebida> bebidas = bebidaRepository.findAll();
        List<TotalEstoqueDTO> totalListEstoqueDTO = new ArrayList<TotalEstoqueDTO>();

        for (TipoBebida tipoBebida : tipoBebidas) {
            TotalEstoqueDTO total = new TotalEstoqueDTO();
            total.setTotal(0);
            total.setTipoBebida(tipoBebida.getTipo());

            totalListEstoqueDTO.add(total);
        }

        for (Bebida bebida : bebidas) {
            for (TotalEstoqueDTO estoque : totalListEstoqueDTO) {
                if (bebida.getTipoBebidaId().getTipo().equals(estoque.getTipoBebida())) {
                    estoque.setTotal(estoque.getTotal() + bebida.getQuantidadeLitros());
                }
            }
        }

        return totalListEstoqueDTO;
    }

    public MensagemResposta registrarVenda(VendaDTO venda) {
        MensagemResposta mensagemResposta = new MensagemResposta();

        try {
            Secao secao = secaoRepository.findByCodigo(venda.getCodigoSecao());
            if (secao == null) {
                //secao nao encontrada
                mensagemResposta.setMensagem("Seção não encontrada");
                mensagemResposta.setStatusRequisicao(false);

                return mensagemResposta;
            }

            if (!secao.getTipoBebidaId().getTipo().equals(venda.getTipoBebida())) {
                mensagemResposta.setMensagem("Tipo de bebida não se encontra nessa seção");
                mensagemResposta.setStatusRequisicao(false);

                return mensagemResposta;
            }

            Bebida bebida = bebidaRepository.findBySecaoId(secao);
            if (bebida != null) {
                if (bebida.getQuantidadeLitros() >= venda.getQuantidade()) {
                    bebida.setQuantidadeLitros(bebida.getQuantidadeLitros() - venda.getQuantidade());

                    if (bebida.getQuantidadeLitros() == 0) {
                        secao.setTipoBebidaId(null);
                        bebidaRepository.delete(bebida);
                        secaoRepository.save(secao);
                    } else {
                        bebidaRepository.save(bebida);
                    }

                    this.salvarHistorico(bebida.getTipoBebidaId(), secao, venda.getResponsavel(), venda.getQuantidade(), MensagemHistorico.VENDA_BEBIDA);

                    mensagemResposta.setMensagem("Venda realizada com sucesso!");
                    mensagemResposta.setStatusRequisicao(true);

                    return mensagemResposta;

                } else {
                    mensagemResposta.setMensagem("Quantidade indisponível na seção: " + bebida.getSecaoId().getCodigo());
                    mensagemResposta.setStatusRequisicao(false);

                    return mensagemResposta;
                }
            } else {
                mensagemResposta.setMensagem("Seção vazia");
                mensagemResposta.setStatusRequisicao(false);

                return mensagemResposta;
            }

        } catch (Exception e) {
            mensagemResposta.setMensagem("Erro ao realizar venda");
            mensagemResposta.setStatusRequisicao(false);
            e.printStackTrace();

            return mensagemResposta;
        }
    }

}
