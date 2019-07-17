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
public class RequisitoContenidoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requisito_id")
    private int requisitoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requisito_fases_id")
    private int requisitoFasesId;

    public RequisitoContenidoPK() {
    }

    public RequisitoContenidoPK(int id, int requisitoId, int requisitoFasesId) {
        this.id = id;
        this.requisitoId = requisitoId;
        this.requisitoFasesId = requisitoFasesId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequisitoId() {
        return requisitoId;
    }

    public void setRequisitoId(int requisitoId) {
        this.requisitoId = requisitoId;
    }

    public int getRequisitoFasesId() {
        return requisitoFasesId;
    }

    public void setRequisitoFasesId(int requisitoFasesId) {
        this.requisitoFasesId = requisitoFasesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) requisitoId;
        hash += (int) requisitoFasesId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitoContenidoPK)) {
            return false;
        }
        RequisitoContenidoPK other = (RequisitoContenidoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.requisitoId != other.requisitoId) {
            return false;
        }
        if (this.requisitoFasesId != other.requisitoFasesId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.RequisitoContenidoPK[ id=" + id + ", requisitoId=" + requisitoId + ", requisitoFasesId=" + requisitoFasesId + " ]";
    }
    
}
