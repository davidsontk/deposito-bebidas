package br.com.principal.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author davidson ferreira
 */
@Entity
@Table(name = "tipo_bebida")
public class TipoBebida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 100)
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "quantidade_litros")
    private Integer quantidadeLitros;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
