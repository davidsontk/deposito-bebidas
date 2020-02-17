package br.com.principal.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author davidson ferreira
 */
@Entity
@Table(name = "bebida")
public class Bebida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantidade_litros")
    private Integer quantidadeLitros;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "tipo_bebida_id")
    private TipoBebida tipoBebidaId;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "secao_id")
    private Secao secaoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidadeLitros() {
        return quantidadeLitros;
    }

    public void setQuantidadeLitros(Integer quantidadeLitros) {
        this.quantidadeLitros = quantidadeLitros;
    }

    public TipoBebida getTipoBebidaId() {
        return tipoBebidaId;
    }

    public void setTipoBebidaId(TipoBebida tipoBebidaId) {
        this.tipoBebidaId = tipoBebidaId;
    }

    public Secao getSecaoId() {
        return secaoId;
    }

    public void setSecaoId(Secao secaoId) {
        this.secaoId = secaoId;
    }

}
