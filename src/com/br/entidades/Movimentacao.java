/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DANILO
 */
@Entity
@Table(name = "movimentacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentacao.findAll", query = "SELECT m FROM Movimentacao m")
    , @NamedQuery(name = "Movimentacao.findByIdmovimentacao", query = "SELECT m FROM Movimentacao m WHERE m.idmovimentacao = :idmovimentacao")
    , @NamedQuery(name = "Movimentacao.findByValor", query = "SELECT m FROM Movimentacao m WHERE m.valor = :valor")
    , @NamedQuery(name = "Movimentacao.findByData", query = "SELECT m FROM Movimentacao m WHERE m.data = :data")
    , @NamedQuery(name = "Movimentacao.findByDatacadastro", query = "SELECT m FROM Movimentacao m WHERE m.datacadastro = :datacadastro")
    , @NamedQuery(name = "Movimentacao.findByOservacao", query = "SELECT m FROM Movimentacao m WHERE m.oservacao = :oservacao")})
public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idmovimentacao")
    private Integer idmovimentacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "datacadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacadastro;
    @Column(name = "oservacao")
    private String oservacao;
    @JoinColumn(name = "idcategoria", referencedColumnName = "idcategoria")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Categoria idcategoria;

    public Movimentacao() {
    }

    public Movimentacao(Integer idmovimentacao) {
        this.idmovimentacao = idmovimentacao;
    }

    public Integer getIdmovimentacao() {
        return idmovimentacao;
    }

    public void setIdmovimentacao(Integer idmovimentacao) {
        this.idmovimentacao = idmovimentacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getOservacao() {
        return oservacao;
    }

    public void setOservacao(String oservacao) {
        this.oservacao = oservacao;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmovimentacao != null ? idmovimentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        if ((this.idmovimentacao == null && other.idmovimentacao != null) || (this.idmovimentacao != null && !this.idmovimentacao.equals(other.idmovimentacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.entidades.Movimentacao[ idmovimentacao=" + idmovimentacao + " ]";
    }
    
}
