/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "secao")
public class Secao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "codigo")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "tipo_bebida_id")
    private TipoBebida tipoBebidaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public TipoBebida getTipoBebidaId() {
        return tipoBebidaId;
    }

    public void setTipoBebidaId(TipoBebida tipoBebidaId) {
        this.tipoBebidaId = tipoBebidaId;
    }

}
