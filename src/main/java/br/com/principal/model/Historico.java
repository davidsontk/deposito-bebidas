package br.com.principal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author davidson ferreira
 */
@Entity
@Table(name = "historico")
public class Historico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora")
    private Date dataHora;

    @JoinColumn(referencedColumnName = "id", name = "tipo_bebida_id")
    @ManyToOne
    private TipoBebida tipoBebidaId;

    @JoinColumn(referencedColumnName = "id", name = "secao_id")
    @ManyToOne
    private Secao secaoId;

    @Column(name = "responsavel")
    private String responsavel;

    @Column(name = "tipo")
    private String tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
