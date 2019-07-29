/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desarrollo
 */
@Entity
@Table(name = "nitrogeno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nitrogeno.findAll", query = "SELECT n FROM Nitrogeno n"),
    @NamedQuery(name = "Nitrogeno.findById", query = "SELECT n FROM Nitrogeno n WHERE n.id = :id"),
    @NamedQuery(name = "Nitrogeno.findByNombreNitrogeno", query = "SELECT n FROM Nitrogeno n WHERE n.nombreNitrogeno = :nombreNitrogeno")})
public class Nitrogeno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre_nitrogeno")
    private String nombreNitrogeno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nitrogeno")
    private List<Productos> productosList;

    public Nitrogeno() {
    }

    public Nitrogeno(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreNitrogeno() {
        return nombreNitrogeno;
    }

    public void setNombreNitrogeno(String nombreNitrogeno) {
        this.nombreNitrogeno = nombreNitrogeno;
    }

    @XmlTransient
    public List<Productos> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Productos> productosList) {
        this.productosList = productosList;
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
        if (!(object instanceof Nitrogeno)) {
            return false;
        }
        Nitrogeno other = (Nitrogeno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Nitrogeno[ id=" + id + " ]";
    }
    
}
