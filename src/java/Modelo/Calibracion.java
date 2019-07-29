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
@Table(name = "calibracion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calibracion.findAll", query = "SELECT c FROM Calibracion c"),
    @NamedQuery(name = "Calibracion.findById", query = "SELECT c FROM Calibracion c WHERE c.calibracionPK.id = :id"),
    @NamedQuery(name = "Calibracion.findByIdTractor", query = "SELECT c FROM Calibracion c WHERE c.idTractor = :idTractor"),
    @NamedQuery(name = "Calibracion.findByOperario", query = "SELECT c FROM Calibracion c WHERE c.operario = :operario"),
    @NamedQuery(name = "Calibracion.findBySectSue", query = "SELECT c FROM Calibracion c WHERE c.sectSue = :sectSue"),
    @NamedQuery(name = "Calibracion.findByIdImplementos", query = "SELECT c FROM Calibracion c WHERE c.idImplementos = :idImplementos"),
    @NamedQuery(name = "Calibracion.findByValorCalibracion", query = "SELECT c FROM Calibracion c WHERE c.valorCalibracion = :valorCalibracion"),
    @NamedQuery(name = "Calibracion.findByDosisHa", query = "SELECT c FROM Calibracion c WHERE c.dosisHa = :dosisHa"),
    @NamedQuery(name = "Calibracion.findByFecha", query = "SELECT c FROM Calibracion c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Calibracion.findByProductosIdPotasio", query = "SELECT c FROM Calibracion c WHERE c.calibracionPK.productosIdPotasio = :productosIdPotasio"),
    @NamedQuery(name = "Calibracion.findByProductosIdNitrogeno", query = "SELECT c FROM Calibracion c WHERE c.calibracionPK.productosIdNitrogeno = :productosIdNitrogeno")})
public class Calibracion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalibracionPK calibracionPK;
    @Column(name = "id_tractor")
    private Integer idTractor;
    @Size(max = 45)
    @Column(name = "operario")
    private String operario;
    @Size(max = 45)
    @Column(name = "sect_sue")
    private String sectSue;
    @Column(name = "id_implementos")
    private Integer idImplementos;
    @Column(name = "valor_calibracion")
    private Integer valorCalibracion;
    @Column(name = "dosis_ha")
    private Integer dosisHa;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumns({
        @JoinColumn(name = "productos_id_potasio", referencedColumnName = "id_potasio", insertable = false, updatable = false),
        @JoinColumn(name = "productos_id_nitrogeno", referencedColumnName = "id_nitrogeno", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Productos productos;

    public Calibracion() {
    }

    public Calibracion(CalibracionPK calibracionPK) {
        this.calibracionPK = calibracionPK;
    }

    public Calibracion(int id, int productosIdPotasio, int productosIdNitrogeno) {
        this.calibracionPK = new CalibracionPK(id, productosIdPotasio, productosIdNitrogeno);
    }

    public CalibracionPK getCalibracionPK() {
        return calibracionPK;
    }

    public void setCalibracionPK(CalibracionPK calibracionPK) {
        this.calibracionPK = calibracionPK;
    }

    public Integer getIdTractor() {
        return idTractor;
    }

    public void setIdTractor(Integer idTractor) {
        this.idTractor = idTractor;
    }

    public String getOperario() {
        return operario;
    }

    public void setOperario(String operario) {
        this.operario = operario;
    }

    public String getSectSue() {
        return sectSue;
    }

    public void setSectSue(String sectSue) {
        this.sectSue = sectSue;
    }

    public Integer getIdImplementos() {
        return idImplementos;
    }

    public void setIdImplementos(Integer idImplementos) {
        this.idImplementos = idImplementos;
    }

    public Integer getValorCalibracion() {
        return valorCalibracion;
    }

    public void setValorCalibracion(Integer valorCalibracion) {
        this.valorCalibracion = valorCalibracion;
    }

    public Integer getDosisHa() {
        return dosisHa;
    }

    public void setDosisHa(Integer dosisHa) {
        this.dosisHa = dosisHa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calibracionPK != null ? calibracionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calibracion)) {
            return false;
        }
        Calibracion other = (Calibracion) object;
        if ((this.calibracionPK == null && other.calibracionPK != null) || (this.calibracionPK != null && !this.calibracionPK.equals(other.calibracionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Calibracion[ calibracionPK=" + calibracionPK + " ]";
    }
    
}
