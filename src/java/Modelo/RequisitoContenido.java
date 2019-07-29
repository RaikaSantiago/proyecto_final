/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desarrollo
 */
@Entity
@Table(name = "requisito_contenido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequisitoContenido.findAll", query = "SELECT r FROM RequisitoContenido r"),
    @NamedQuery(name = "RequisitoContenido.findById", query = "SELECT r FROM RequisitoContenido r WHERE r.requisitoContenidoPK.id = :id"),
    @NamedQuery(name = "RequisitoContenido.findByNombreProyecto", query = "SELECT r FROM RequisitoContenido r WHERE r.nombreProyecto = :nombreProyecto"),
    @NamedQuery(name = "RequisitoContenido.findByNumeroSolicitud", query = "SELECT r FROM RequisitoContenido r WHERE r.numeroSolicitud = :numeroSolicitud"),
    @NamedQuery(name = "RequisitoContenido.findByTitulo", query = "SELECT r FROM RequisitoContenido r WHERE r.titulo = :titulo"),
    @NamedQuery(name = "RequisitoContenido.findByFecha", query = "SELECT r FROM RequisitoContenido r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "RequisitoContenido.findBySolicitante", query = "SELECT r FROM RequisitoContenido r WHERE r.solicitante = :solicitante"),
    @NamedQuery(name = "RequisitoContenido.findByOrigen", query = "SELECT r FROM RequisitoContenido r WHERE r.origen = :origen"),
    @NamedQuery(name = "RequisitoContenido.findByEstado", query = "SELECT r FROM RequisitoContenido r WHERE r.estado = :estado"),
    @NamedQuery(name = "RequisitoContenido.findByPrioridadSolicitante", query = "SELECT r FROM RequisitoContenido r WHERE r.prioridadSolicitante = :prioridadSolicitante"),
    @NamedQuery(name = "RequisitoContenido.findByPrioridadRealizacion", query = "SELECT r FROM RequisitoContenido r WHERE r.prioridadRealizacion = :prioridadRealizacion"),
    @NamedQuery(name = "RequisitoContenido.findByVerificador", query = "SELECT r FROM RequisitoContenido r WHERE r.verificador = :verificador"),
    @NamedQuery(name = "RequisitoContenido.findByFechaActualizacion", query = "SELECT r FROM RequisitoContenido r WHERE r.fechaActualizacion = :fechaActualizacion"),
    @NamedQuery(name = "RequisitoContenido.findByRelease", query = "SELECT r FROM RequisitoContenido r WHERE r.release = :release"),
    @NamedQuery(name = "RequisitoContenido.findByEsfuerzo", query = "SELECT r FROM RequisitoContenido r WHERE r.esfuerzo = :esfuerzo"),
    @NamedQuery(name = "RequisitoContenido.findByDescripcion", query = "SELECT r FROM RequisitoContenido r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "RequisitoContenido.findByComentarios", query = "SELECT r FROM RequisitoContenido r WHERE r.comentarios = :comentarios"),
    @NamedQuery(name = "RequisitoContenido.findByRequisitoId", query = "SELECT r FROM RequisitoContenido r WHERE r.requisitoContenidoPK.requisitoId = :requisitoId"),
    @NamedQuery(name = "RequisitoContenido.findByRequisitoFasesId", query = "SELECT r FROM RequisitoContenido r WHERE r.requisitoContenidoPK.requisitoFasesId = :requisitoFasesId")})
public class RequisitoContenido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitoContenidoPK requisitoContenidoPK;
    @Size(max = 45)
    @Column(name = "nombre_proyecto")
    private String nombreProyecto;
    @Column(name = "numero_solicitud")
    private Integer numeroSolicitud;
    @Size(max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "solicitante")
    private String solicitante;
    @Size(max = 45)
    @Column(name = "origen")
    private String origen;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 45)
    @Column(name = "prioridad_solicitante")
    private String prioridadSolicitante;
    @Size(max = 45)
    @Column(name = "prioridad_realizacion")
    private String prioridadRealizacion;
    @Size(max = 45)
    @Column(name = "verificador")
    private String verificador;
    @Column(name = "fecha_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Size(max = 45)
    @Column(name = "release")
    private String release;
    @Size(max = 45)
    @Column(name = "esfuerzo")
    private String esfuerzo;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumns({
        @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "requisito_id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "requisito_fases_id", referencedColumnName = "fases_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Requisito requisito;

    public RequisitoContenido() {
    }

    public RequisitoContenido(RequisitoContenidoPK requisitoContenidoPK) {
        this.requisitoContenidoPK = requisitoContenidoPK;
    }

    public RequisitoContenido(int id, int requisitoId, int requisitoFasesId) {
        this.requisitoContenidoPK = new RequisitoContenidoPK(id, requisitoId, requisitoFasesId);
    }

    public RequisitoContenidoPK getRequisitoContenidoPK() {
        return requisitoContenidoPK;
    }

    public void setRequisitoContenidoPK(RequisitoContenidoPK requisitoContenidoPK) {
        this.requisitoContenidoPK = requisitoContenidoPK;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Integer getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(Integer numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridadSolicitante() {
        return prioridadSolicitante;
    }

    public void setPrioridadSolicitante(String prioridadSolicitante) {
        this.prioridadSolicitante = prioridadSolicitante;
    }

    public String getPrioridadRealizacion() {
        return prioridadRealizacion;
    }

    public void setPrioridadRealizacion(String prioridadRealizacion) {
        this.prioridadRealizacion = prioridadRealizacion;
    }

    public String getVerificador() {
        return verificador;
    }

    public void setVerificador(String verificador) {
        this.verificador = verificador;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getEsfuerzo() {
        return esfuerzo;
    }

    public void setEsfuerzo(String esfuerzo) {
        this.esfuerzo = esfuerzo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Requisito getRequisito() {
        return requisito;
    }

    public void setRequisito(Requisito requisito) {
        this.requisito = requisito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitoContenidoPK != null ? requisitoContenidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequisitoContenido)) {
            return false;
        }
        RequisitoContenido other = (RequisitoContenido) object;
        if ((this.requisitoContenidoPK == null && other.requisitoContenidoPK != null) || (this.requisitoContenidoPK != null && !this.requisitoContenidoPK.equals(other.requisitoContenidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.RequisitoContenido[ requisitoContenidoPK=" + requisitoContenidoPK + " ]";
    }
    
}
