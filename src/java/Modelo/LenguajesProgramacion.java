/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "lenguajes_programacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LenguajesProgramacion.findAll", query = "SELECT l FROM LenguajesProgramacion l")
    , @NamedQuery(name = "LenguajesProgramacion.findById", query = "SELECT l FROM LenguajesProgramacion l WHERE l.id = :id")
    , @NamedQuery(name = "LenguajesProgramacion.findByNombre", query = "SELECT l FROM LenguajesProgramacion l WHERE l.nombre = :nombre")})
public class LenguajesProgramacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @ManyToMany(mappedBy = "lenguajesProgramacionList")
    private List<Empleados> empleadosList;
    @JoinTable(name = "programa_proyecto", joinColumns = {
        @JoinColumn(name = "lenguajes_programacion_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "proyectos_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Proyectos> proyectosList;

    public LenguajesProgramacion() {
    }

    public LenguajesProgramacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
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
        if (!(object instanceof LenguajesProgramacion)) {
            return false;
        }
        LenguajesProgramacion other = (LenguajesProgramacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.LenguajesProgramacion[ id=" + id + " ]";
    }
    
}
