/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "grados_academicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GradosAcademicos.findAll", query = "SELECT g FROM GradosAcademicos g")
    , @NamedQuery(name = "GradosAcademicos.findById", query = "SELECT g FROM GradosAcademicos g WHERE g.gradosAcademicosPK.id = :id")
    , @NamedQuery(name = "GradosAcademicos.findByTipo", query = "SELECT g FROM GradosAcademicos g WHERE g.tipo = :tipo")
    , @NamedQuery(name = "GradosAcademicos.findByUniversidadId", query = "SELECT g FROM GradosAcademicos g WHERE g.gradosAcademicosPK.universidadId = :universidadId")})
public class GradosAcademicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GradosAcademicosPK gradosAcademicosPK;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @ManyToMany(mappedBy = "gradosAcademicosList")
    private List<Empleados> empleadosList;
    @JoinColumn(name = "universidad_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Universidad universidad;

    public GradosAcademicos() {
    }

    public GradosAcademicos(GradosAcademicosPK gradosAcademicosPK) {
        this.gradosAcademicosPK = gradosAcademicosPK;
    }

    public GradosAcademicos(int id, int universidadId) {
        this.gradosAcademicosPK = new GradosAcademicosPK(id, universidadId);
    }

    public GradosAcademicosPK getGradosAcademicosPK() {
        return gradosAcademicosPK;
    }

    public void setGradosAcademicosPK(GradosAcademicosPK gradosAcademicosPK) {
        this.gradosAcademicosPK = gradosAcademicosPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gradosAcademicosPK != null ? gradosAcademicosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradosAcademicos)) {
            return false;
        }
        GradosAcademicos other = (GradosAcademicos) object;
        if ((this.gradosAcademicosPK == null && other.gradosAcademicosPK != null) || (this.gradosAcademicosPK != null && !this.gradosAcademicosPK.equals(other.gradosAcademicosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.GradosAcademicos[ gradosAcademicosPK=" + gradosAcademicosPK + " ]";
    }
    
}
