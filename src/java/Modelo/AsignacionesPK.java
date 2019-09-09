/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ALEJANDRA
 */
@Embeddable
public class AsignacionesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empleados_id")
    private int empleadosId;

    public AsignacionesPK() {
    }

    public AsignacionesPK(int id, int empleadosId) {
        this.id = id;
        this.empleadosId = empleadosId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpleadosId() {
        return empleadosId;
    }

    public void setEmpleadosId(int empleadosId) {
        this.empleadosId = empleadosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) empleadosId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionesPK)) {
            return false;
        }
        AsignacionesPK other = (AsignacionesPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.empleadosId != other.empleadosId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.AsignacionesPK[ id=" + id + ", empleadosId=" + empleadosId + " ]";
    }
    
}
