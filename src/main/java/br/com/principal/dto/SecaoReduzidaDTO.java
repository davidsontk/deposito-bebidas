package br.com.principal.dto;

import br.com.principal.model.Secao;

/**
 *
 * @author davidson ferreira
 */
public class SecaoReduzidaDTO {

    private Integer codigoSecao;
    private String tipoBebida;

    public SecaoReduzidaDTO(Secao secao) {
        this.codigoSecao = secao.getCodigo();
        this.tipoBebida = secao.getTipoBebidaId() != null ? secao.getTipoBebidaId().getTipo() : null;
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
