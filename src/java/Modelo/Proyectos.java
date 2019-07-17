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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

/**
 *
 * @author ALEJANDRA
 */
@Entity
@Table(name = "proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p")
    , @NamedQuery(name = "Proyectos.findById", query = "SELECT p FROM Proyectos p WHERE p.id = :id")
    , @NamedQuery(name = "Proyectos.findByCodigo", query = "SELECT p FROM Proyectos p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Proyectos.findByNombre", query = "SELECT p FROM Proyectos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proyectos.findByArea", query = "SELECT p FROM Proyectos p WHERE p.area = :area")
    , @NamedQuery(name = "Proyectos.findByFecha", query = "SELECT p FROM Proyectos p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Proyectos.findByFechaAsignacion", query = "SELECT p FROM Proyectos p WHERE p.fechaAsignacion = :fechaAsignacion")
    , @NamedQuery(name = "Proyectos.findByFechaLiberacion", query = "SELECT p FROM Proyectos p WHERE p.fechaLiberacion = :fechaLiberacion")
    , @NamedQuery(name = "Proyectos.findByFechaFases", query = "SELECT p FROM Proyectos p WHERE p.fechaFases = :fechaFases")
    , @NamedQuery(name = "Proyectos.findByCostoTotal", query = "SELECT p FROM Proyectos p WHERE p.costoTotal = :costoTotal")})
public class Proyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "area")
    private String area;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "fecha_asignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Column(name = "fecha_liberacion")
    @Temporal(TemporalType.DATE)
    private Date fechaLiberacion;
    @Column(name = "fecha_fases")
    @Temporal(TemporalType.DATE)
    private Date fechaFases;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costo_total")
    private Float costoTotal;
    @ManyToMany(mappedBy = "proyectosList")
    private List<BaseDatos> baseDatosList;
    @ManyToMany(mappedBy = "proyectosList")
    private List<Empleados> empleadosList;
    @JoinTable(name = "so_proyecto", joinColumns = {
        @JoinColumn(name = "proyectos_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "sistema_operativo_id", referencedColumnName = "id")})
    @ManyToMany
    private List<SistemaOperativo> sistemaOperativoList;
    @ManyToMany(mappedBy = "proyectosList")
    private List<LenguajesProgramacion> lenguajesProgramacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectos")
    private List<Requisito> requisitoList;

    public Proyectos() {
    }

    public Proyectos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaLiberacion() {
        return fechaLiberacion;
    }

    public void setFechaLiberacion(Date fechaLiberacion) {
        this.fechaLiberacion = fechaLiberacion;
    }

    public Date getFechaFases() {
        return fechaFases;
    }

    public void setFechaFases(Date fechaFases) {
        this.fechaFases = fechaFases;
    }

    public Float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Float costoTotal) {
        this.costoTotal = costoTotal;
    }

    @XmlTransient
    public List<BaseDatos> getBaseDatosList() {
        return baseDatosList;
    }

    public void setBaseDatosList(List<BaseDatos> baseDatosList) {
        this.baseDatosList = baseDatosList;
    }

    @XmlTransient
    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    @XmlTransient
    public List<SistemaOperativo> getSistemaOperativoList() {
        return sistemaOperativoList;
    }

    public void setSistemaOperativoList(List<SistemaOperativo> sistemaOperativoList) {
        this.sistemaOperativoList = sistemaOperativoList;
    }

    @XmlTransient
    public List<LenguajesProgramacion> getLenguajesProgramacionList() {
        return lenguajesProgramacionList;
    }

    public void setLenguajesProgramacionList(List<LenguajesProgramacion> lenguajesProgramacionList) {
        this.lenguajesProgramacionList = lenguajesProgramacionList;
    }

    @XmlTransient
    public List<Requisito> getRequisitoList() {
        return requisitoList;
    }

    public void setRequisitoList(List<Requisito> requisitoList) {
        this.requisitoList = requisitoList;
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
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Proyectos[ id=" + id + " ]";
    }
    
}
