/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ageeu
 */
@Entity
@Table(name = "dividas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divida.findAll", query = "SELECT d FROM Divida d")
    , @NamedQuery(name = "Divida.findByIdDivida", query = "SELECT d FROM Divida d WHERE d.idDivida = :idDivida")
    , @NamedQuery(name = "Divida.findByDescricao", query = "SELECT d FROM Divida d WHERE d.descricao = :descricao")
    , @NamedQuery(name = "Divida.findByDataDivida", query = "SELECT d FROM Divida d WHERE d.dataDivida = :dataDivida")
    , @NamedQuery(name = "Divida.findByValor", query = "SELECT d FROM Divida d WHERE d.valor = :valor")
    , @NamedQuery(name = "Divida.findByStatus", query = "SELECT d FROM Divida d WHERE d.status = :status")})
public class Divida implements EntityBase {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_divida")
    private Long idDivida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataDivida")
    @Temporal(TemporalType.DATE)
    private Date dataDivida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private long valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
    @ManyToOne(optional = false)
    private Tipo idTipo;

    public Divida() {
    }

    public Divida(Long idDivida) {
        this.idDivida = idDivida;
    }

    public Divida(Long idDivida, String descricao, Date dataDivida, long valor, String status) {
        this.idDivida = idDivida;
        this.descricao = descricao;
        this.dataDivida = dataDivida;
        this.valor = valor;
        this.status = status;
    }

    public Long getIdDivida() {
        return idDivida;
    }

    public void setIdDivida(Long idDivida) {
        this.idDivida = idDivida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDivida() {
        return dataDivida;
    }

    public void setDataDivida(Date dataDivida) {
        this.dataDivida = dataDivida;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDivida != null ? idDivida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divida)) {
            return false;
        }
        Divida other = (Divida) object;
        if ((this.idDivida == null && other.idDivida != null) || (this.idDivida != null && !this.idDivida.equals(other.idDivida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.dao.entidades.Divida[ idDivida=" + idDivida + " ]";
    }

    @Override
    public Long getId() {
        return idDivida;
    }
    
}
