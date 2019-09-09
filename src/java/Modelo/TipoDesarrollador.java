/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ALEJANDRA
 */
@Entity
@Table(name = "tipo_desarrollador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDesarrollador.findAll", query = "SELECT t FROM TipoDesarrollador t")
    , @NamedQuery(name = "TipoDesarrollador.findById", query = "SELECT t FROM TipoDesarrollador t WHERE t.id = :id")
    , @NamedQuery(name = "TipoDesarrollador.findByNombreCargo", query = "SELECT t FROM TipoDesarrollador t WHERE t.nombreCargo = :nombreCargo")})
public class TipoDesarrollador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre_cargo")
    private String nombreCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDesarrolladorId")
    private List<Empleados> empleadosList;

    public TipoDesarrollador() {
    }

    public TipoDesarrollador(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDesarrollador)) {
            return false;
        }
        TipoDesarrollador other = (TipoDesarrollador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.TipoDesarrollador[ id=" + id + " ]";
    }
    
}
