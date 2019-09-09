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
public class RequisitoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fases_id")
    private int fasesId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proyectos_id")
    private int proyectosId;

    public RequisitoPK() {
    }

    public RequisitoPK(int id, int fasesId, int proyectosId) {
        this.id = id;
        this.fasesId = fasesId;
        this.proyectosId = proyectosId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFasesId() {
        return fasesId;
    }

    public void setFasesId(int fasesId) {
        this.fasesId = fasesId;
    }

    public int getProyectosId() {
        return proyectosId;
    }

    public void setProyectosId(int proyectosId) {
        this.proyectosId = proyectosId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) fasesId;
        hash += (int) proyectosId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitoPK)) {
            return false;
        }
        RequisitoPK other = (RequisitoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.fasesId != other.fasesId) {
            return false;
        }
        if (this.proyectosId != other.proyectosId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.RequisitoPK[ id=" + id + ", fasesId=" + fasesId + ", proyectosId=" + proyectosId + " ]";
    }
    
}
