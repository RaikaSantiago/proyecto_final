/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALEJANDRA
 */
@Entity
@Table(name = "asignaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignaciones.findAll", query = "SELECT a FROM Asignaciones a")
    , @NamedQuery(name = "Asignaciones.findById", query = "SELECT a FROM Asignaciones a WHERE a.asignacionesPK.id = :id")
    , @NamedQuery(name = "Asignaciones.findByHoras", query = "SELECT a FROM Asignaciones a WHERE a.horas = :horas")
    , @NamedQuery(name = "Asignaciones.findByCantidadProyectos", query = "SELECT a FROM Asignaciones a WHERE a.cantidadProyectos = :cantidadProyectos")
    , @NamedQuery(name = "Asignaciones.findByPresupuestos", query = "SELECT a FROM Asignaciones a WHERE a.presupuestos = :presupuestos")
    , @NamedQuery(name = "Asignaciones.findByEmpleadosId", query = "SELECT a FROM Asignaciones a WHERE a.asignacionesPK.empleadosId = :empleadosId")})
public class Asignaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsignacionesPK asignacionesPK;
    @Column(name = "horas")
    private Integer horas;
    @Column(name = "cantidad_proyectos")
    private Integer cantidadProyectos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "presupuestos")
    private Float presupuestos;
    @JoinColumn(name = "empleados_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleados empleados;

    public Asignaciones() {
    }

    public Asignaciones(AsignacionesPK asignacionesPK) {
        this.asignacionesPK = asignacionesPK;
    }

    public Asignaciones(int id, int empleadosId) {
        this.asignacionesPK = new AsignacionesPK(id, empleadosId);
    }

    public AsignacionesPK getAsignacionesPK() {
        return asignacionesPK;
    }

    public void setAsignacionesPK(AsignacionesPK asignacionesPK) {
        this.asignacionesPK = asignacionesPK;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Integer getCantidadProyectos() {
        return cantidadProyectos;
    }

    public void setCantidadProyectos(Integer cantidadProyectos) {
        this.cantidadProyectos = cantidadProyectos;
    }

    public Float getPresupuestos() {
        return presupuestos;
    }

    public void setPresupuestos(Float presupuestos) {
        this.presupuestos = presupuestos;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignacionesPK != null ? asignacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaciones)) {
            return false;
        }
        Asignaciones other = (Asignaciones) object;
        if ((this.asignacionesPK == null && other.asignacionesPK != null) || (this.asignacionesPK != null && !this.asignacionesPK.equals(other.asignacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Asignaciones[ asignacionesPK=" + asignacionesPK + " ]";
    }
    
}
