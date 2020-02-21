package br.com.principal.dto;

/**
 *
 * @author david
 */
public class TotalEstoqueDTO {

    private String tipoBebida;
    private Integer total;

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
