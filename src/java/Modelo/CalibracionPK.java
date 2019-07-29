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
public class CalibracionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productos_id_potasio")
    private int productosIdPotasio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productos_id_nitrogeno")
    private int productosIdNitrogeno;

    public CalibracionPK() {
    }

    public CalibracionPK(int id, int productosIdPotasio, int productosIdNitrogeno) {
        this.id = id;
        this.productosIdPotasio = productosIdPotasio;
        this.productosIdNitrogeno = productosIdNitrogeno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductosIdPotasio() {
        return productosIdPotasio;
    }

    public void setProductosIdPotasio(int productosIdPotasio) {
        this.productosIdPotasio = productosIdPotasio;
    }

    public int getProductosIdNitrogeno() {
        return productosIdNitrogeno;
    }

    public void setProductosIdNitrogeno(int productosIdNitrogeno) {
        this.productosIdNitrogeno = productosIdNitrogeno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) productosIdPotasio;
        hash += (int) productosIdNitrogeno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalibracionPK)) {
            return false;
        }
        CalibracionPK other = (CalibracionPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.productosIdPotasio != other.productosIdPotasio) {
            return false;
        }
        if (this.productosIdNitrogeno != other.productosIdNitrogeno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.CalibracionPK[ id=" + id + ", productosIdPotasio=" + productosIdPotasio + ", productosIdNitrogeno=" + productosIdNitrogeno + " ]";
    }
    
}
