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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ALEJANDRA
 */
@Entity
@Table(name = "base_datos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BaseDatos.findAll", query = "SELECT b FROM BaseDatos b")
    , @NamedQuery(name = "BaseDatos.findById", query = "SELECT b FROM BaseDatos b WHERE b.id = :id")
    , @NamedQuery(name = "BaseDatos.findByNombre", query = "SELECT b FROM BaseDatos b WHERE b.nombre = :nombre")
    , @NamedQuery(name = "BaseDatos.findByTipo", query = "SELECT b FROM BaseDatos b WHERE b.tipo = :tipo")})
public class BaseDatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @JoinTable(name = "db_proyecto", joinColumns = {
        @JoinColumn(name = "base_datos_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "proyectos_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Proyectos> proyectosList;
    @JoinTable(name = "db_empleados", joinColumns = {
        @JoinColumn(name = "base_datos_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "empleados_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Empleados> empleadosList;

    public BaseDatos() {
    }

    public BaseDatos(Integer id) {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
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
        if (!(object instanceof BaseDatos)) {
            return false;
        }
        BaseDatos other = (BaseDatos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.BaseDatos[ id=" + id + " ]";
    }
    
}
