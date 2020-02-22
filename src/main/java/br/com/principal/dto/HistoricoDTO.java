package br.com.principal.dto;

import br.com.principal.model.Historico;
import java.util.Date;

/**
 *
 * @author david
 */
public class HistoricoDTO {

    private Date dataHora;
    private String tipo;
    private Integer quantidadeLitros;
    private String responsavel;
    private Integer codigoSecao;
    private String tipoBebida;

    public HistoricoDTO(Historico h) {
        this.dataHora = h.getDataHora();
        this.tipo = h.getTipo();
        this.quantidadeLitros = h.getQuantidadeLitros();
        this.responsavel = h.getResponsavel();
        this.codigoSecao = h.getSecaoId().getCodigo();
        this.tipoBebida = h.getTipoBebidaId().getTipo();

    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidadeLitros() {
        return quantidadeLitros;
    }

    public void setQuantidadeLitros(Integer quantidadeLitros) {
        this.quantidadeLitros = quantidadeLitros;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Integer getCodigoSecao() {
        return codigoSecao;
    }

    public void setCodigoSecao(Integer codigoSecao) {
        this.codigoSecao = codigoSecao;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

}
