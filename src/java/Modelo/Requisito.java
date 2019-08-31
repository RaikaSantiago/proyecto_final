/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "requisito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisito.findAll", query = "SELECT r FROM Requisito r")
    , @NamedQuery(name = "Requisito.findById", query = "SELECT r FROM Requisito r WHERE r.requisitoPK.id = :id")
    , @NamedQuery(name = "Requisito.findByDescripcion", query = "SELECT r FROM Requisito r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Requisito.findByTipo", query = "SELECT r FROM Requisito r WHERE r.tipo = :tipo")
    , @NamedQuery(name = "Requisito.findByEstado", query = "SELECT r FROM Requisito r WHERE r.estado = :estado")
    , @NamedQuery(name = "Requisito.findByFasesId", query = "SELECT r FROM Requisito r WHERE r.requisitoPK.fasesId = :fasesId")
    , @NamedQuery(name = "Requisito.findByProyectosId", query = "SELECT r FROM Requisito r WHERE r.requisitoPK.proyectosId = :proyectosId")})
public class Requisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitoPK requisitoPK;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requisito")
    private List<RequisitoContenido> requisitoContenidoList;
    @JoinColumn(name = "fases_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fases fases;
    @JoinColumn(name = "proyectos_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;

    public Requisito() {
    }

    public Requisito(RequisitoPK requisitoPK) {
        this.requisitoPK = requisitoPK;
    }

    public Requisito(int id, int fasesId, int proyectosId) {
        this.requisitoPK = new RequisitoPK(id, fasesId, proyectosId);
    }

    public RequisitoPK getRequisitoPK() {
        return requisitoPK;
    }

    public void setRequisitoPK(RequisitoPK requisitoPK) {
        this.requisitoPK = requisitoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<RequisitoContenido> getRequisitoContenidoList() {
        return requisitoContenidoList;
    }

    public void setRequisitoContenidoList(List<RequisitoContenido> requisitoContenidoList) {
        this.requisitoContenidoList = requisitoContenidoList;
    }

    public Fases getFases() {
        return fases;
    }

    public void setFases(Fases fases) {
        this.fases = fases;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitoPK != null ? requisitoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisito)) {
            return false;
        }
        Requisito other = (Requisito) object;
        if ((this.requisitoPK == null && other.requisitoPK != null) || (this.requisitoPK != null && !this.requisitoPK.equals(other.requisitoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Requisito[ requisitoPK=" + requisitoPK + " ]";
    }
    
}
