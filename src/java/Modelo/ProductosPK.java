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
 * @author Desarrollo
 */
@Embeddable
public class ProductosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_potasio")
    private int idPotasio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nitrogeno")
    private int idNitrogeno;

    public ProductosPK() {
    }

    public ProductosPK(int idPotasio, int idNitrogeno) {
        this.idPotasio = idPotasio;
        this.idNitrogeno = idNitrogeno;
    }

    public int getIdPotasio() {
        return idPotasio;
    }

    public void setIdPotasio(int idPotasio) {
        this.idPotasio = idPotasio;
    }

    public int getIdNitrogeno() {
        return idNitrogeno;
    }

    public void setIdNitrogeno(int idNitrogeno) {
        this.idNitrogeno = idNitrogeno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPotasio;
        hash += (int) idNitrogeno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosPK)) {
            return false;
        }
        ProductosPK other = (ProductosPK) object;
        if (this.idPotasio != other.idPotasio) {
            return false;
        }
        if (this.idNitrogeno != other.idNitrogeno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.ProductosPK[ idPotasio=" + idPotasio + ", idNitrogeno=" + idNitrogeno + " ]";
    }
    
}
