package br.com.principal.dto;

/**
 *
 * @author davidson ferreira
 */
public class CadastroBebidaDTO {

    private String tipoBebida;
    private Integer quantidadeLitros;
    private Integer codigoSecao;
    private String nomeResponsavel;

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public Integer getQuantidadeLitros() {
        return quantidadeLitros;
    }

    public void setQuantidadeLitros(Integer quantidadeLitros) {
        this.quantidadeLitros = quantidadeLitros;
    }

    public Integer getCodigoSecao() {
        return codigoSecao;
    }

    public void setCodigoSecao(Integer codigoSecao) {
        this.codigoSecao = codigoSecao;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

}
