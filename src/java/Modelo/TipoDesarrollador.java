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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "tipo_desarrollador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDesarrollador.findAll", query = "SELECT t FROM TipoDesarrollador t")
    , @NamedQuery(name = "TipoDesarrollador.findById", query = "SELECT t FROM TipoDesarrollador t WHERE t.tipoDesarrolladorPK.id = :id")
    , @NamedQuery(name = "TipoDesarrollador.findByNombreCargo", query = "SELECT t FROM TipoDesarrollador t WHERE t.nombreCargo = :nombreCargo")
    , @NamedQuery(name = "TipoDesarrollador.findByEmpleadosId", query = "SELECT t FROM TipoDesarrollador t WHERE t.tipoDesarrolladorPK.empleadosId = :empleadosId")})
public class TipoDesarrollador implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TipoDesarrolladorPK tipoDesarrolladorPK;
    @Size(max = 45)
    @Column(name = "nombre_cargo")
    private String nombreCargo;
    @JoinColumn(name = "empleados_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleados empleados;

    public TipoDesarrollador() {
    }

    public TipoDesarrollador(TipoDesarrolladorPK tipoDesarrolladorPK) {
        this.tipoDesarrolladorPK = tipoDesarrolladorPK;
    }

    public TipoDesarrollador(int id, int empleadosId) {
        this.tipoDesarrolladorPK = new TipoDesarrolladorPK(id, empleadosId);
    }

    public TipoDesarrolladorPK getTipoDesarrolladorPK() {
        return tipoDesarrolladorPK;
    }

    public void setTipoDesarrolladorPK(TipoDesarrolladorPK tipoDesarrolladorPK) {
        this.tipoDesarrolladorPK = tipoDesarrolladorPK;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
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
        hash += (tipoDesarrolladorPK != null ? tipoDesarrolladorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDesarrollador)) {
            return false;
        }
        TipoDesarrollador other = (TipoDesarrollador) object;
        if ((this.tipoDesarrolladorPK == null && other.tipoDesarrolladorPK != null) || (this.tipoDesarrolladorPK != null && !this.tipoDesarrolladorPK.equals(other.tipoDesarrolladorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.TipoDesarrollador[ tipoDesarrolladorPK=" + tipoDesarrolladorPK + " ]";
    }
    
}
