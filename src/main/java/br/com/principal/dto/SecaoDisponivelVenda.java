package br.com.principal.dto;

/**
 *
 * @author david
 */
public class SecaoDisponivelVenda {

    private Integer codigoSecao;
    private String tipoBebida;
    private Integer quantidadeDisponivelVenda;

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

    public Integer getQuantidadeDisponivelVenda() {
        return quantidadeDisponivelVenda;
    }

    public void setQuantidadeDisponivelVenda(Integer quantidadeDisponivelVenda) {
        this.quantidadeDisponivelVenda = quantidadeDisponivelVenda;
    }

}
