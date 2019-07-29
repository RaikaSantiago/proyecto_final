/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desarrollo
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByIdPotasio", query = "SELECT p FROM Productos p WHERE p.productosPK.idPotasio = :idPotasio"),
    @NamedQuery(name = "Productos.findByIdNitrogeno", query = "SELECT p FROM Productos p WHERE p.productosPK.idNitrogeno = :idNitrogeno")})
public class Productos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosPK productosPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private List<Calibracion> calibracionList;
    @JoinColumn(name = "id_nitrogeno", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nitrogeno nitrogeno;
    @JoinColumn(name = "id_potasio", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Potasio potasio;

    public Productos() {
    }

    public Productos(ProductosPK productosPK) {
        this.productosPK = productosPK;
    }

    public Productos(int idPotasio, int idNitrogeno) {
        this.productosPK = new ProductosPK(idPotasio, idNitrogeno);
    }

    public ProductosPK getProductosPK() {
        return productosPK;
    }

    public void setProductosPK(ProductosPK productosPK) {
        this.productosPK = productosPK;
    }

    @XmlTransient
    public List<Calibracion> getCalibracionList() {
        return calibracionList;
    }

    public void setCalibracionList(List<Calibracion> calibracionList) {
        this.calibracionList = calibracionList;
    }

    public Nitrogeno getNitrogeno() {
        return nitrogeno;
    }

    public void setNitrogeno(Nitrogeno nitrogeno) {
        this.nitrogeno = nitrogeno;
    }

    public Potasio getPotasio() {
        return potasio;
    }

    public void setPotasio(Potasio potasio) {
        this.potasio = potasio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosPK != null ? productosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.productosPK == null && other.productosPK != null) || (this.productosPK != null && !this.productosPK.equals(other.productosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Productos[ productosPK=" + productosPK + " ]";
    }
    
}
