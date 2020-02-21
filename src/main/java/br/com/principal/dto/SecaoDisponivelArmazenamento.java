package br.com.principal.dto;

/**
 *
 * @author david
 */
public class SecaoDisponivelArmazenamento {
    
    private Integer codigoSecao;
    private String tipoBebida;
    private Integer quantidadeLitrosDisponivel;

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

    public Integer getQuantidadeLitrosDisponivel() {
        return quantidadeLitrosDisponivel;
    }

    public void setQuantidadeLitrosDisponivel(Integer quantidadeLitrosDisponivel) {
        this.quantidadeLitrosDisponivel = quantidadeLitrosDisponivel;
    }
  
}
