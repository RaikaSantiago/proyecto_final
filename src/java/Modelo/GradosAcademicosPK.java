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
public class GradosAcademicosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "universidad_id")
    private int universidadId;

    public GradosAcademicosPK() {
    }

    public GradosAcademicosPK(int id, int universidadId) {
        this.id = id;
        this.universidadId = universidadId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUniversidadId() {
        return universidadId;
    }

    public void setUniversidadId(int universidadId) {
        this.universidadId = universidadId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) universidadId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradosAcademicosPK)) {
            return false;
        }
        GradosAcademicosPK other = (GradosAcademicosPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.universidadId != other.universidadId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.GradosAcademicosPK[ id=" + id + ", universidadId=" + universidadId + " ]";
    }
    
}
