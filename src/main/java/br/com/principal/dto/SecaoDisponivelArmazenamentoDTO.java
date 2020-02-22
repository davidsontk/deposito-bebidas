package br.com.principal.dto;

/**
 *
 * @author david
 */
public class SecaoDisponivelArmazenamentoDTO {
    
    private Integer codigoSecao;
    private String tipoBebida;
    private Integer quantidadeDisponivelArmazenamento;

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

    public Integer getQuantidadeDisponivelArmazenamento() {
        return quantidadeDisponivelArmazenamento;
    }

    public void setQuantidadeDisponivelArmazenamento(Integer quantidadeDisponivelArmazenamento) {
        this.quantidadeDisponivelArmazenamento = quantidadeDisponivelArmazenamento;
    }
  
}
