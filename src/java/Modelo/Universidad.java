/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "universidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Universidad.findAll", query = "SELECT u FROM Universidad u"),
    @NamedQuery(name = "Universidad.findById", query = "SELECT u FROM Universidad u WHERE u.id = :id"),
    @NamedQuery(name = "Universidad.findByNombre", query = "SELECT u FROM Universidad u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Universidad.findByFechaGrado", query = "SELECT u FROM Universidad u WHERE u.fechaGrado = :fechaGrado"),
    @NamedQuery(name = "Universidad.findByTitulo", query = "SELECT u FROM Universidad u WHERE u.titulo = :titulo")})
public class Universidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_grado")
    @Temporal(TemporalType.DATE)
    private Date fechaGrado;
    @Size(max = 45)
    @Column(name = "titulo")
    private String titulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universidad")
    private List<GradosAcademicos> gradosAcademicosList;

    public Universidad() {
    }

    public Universidad(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaGrado() {
        return fechaGrado;
    }

    public void setFechaGrado(Date fechaGrado) {
        this.fechaGrado = fechaGrado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlTransient
    public List<GradosAcademicos> getGradosAcademicosList() {
        return gradosAcademicosList;
    }

    public void setGradosAcademicosList(List<GradosAcademicos> gradosAcademicosList) {
        this.gradosAcademicosList = gradosAcademicosList;
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
        if (!(object instanceof Universidad)) {
            return false;
        }
        Universidad other = (Universidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Universidad[ id=" + id + " ]";
    }
    
}
