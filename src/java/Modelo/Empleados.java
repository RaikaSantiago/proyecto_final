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


@Entity
@Table(name = "empleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findById", query = "SELECT e FROM Empleados e WHERE e.id = :id"),
    @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleados.findByApellidos", query = "SELECT e FROM Empleados e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleados.findByEmail", query = "SELECT e FROM Empleados e WHERE e.email = :email"),
    @NamedQuery(name = "Empleados.findByCedula", query = "SELECT e FROM Empleados e WHERE e.cedula = :cedula"),
    @NamedQuery(name = "Empleados.findByTelefonoFijo", query = "SELECT e FROM Empleados e WHERE e.telefonoFijo = :telefonoFijo"),
    @NamedQuery(name = "Empleados.findByTelefonoMovil", query = "SELECT e FROM Empleados e WHERE e.telefonoMovil = :telefonoMovil"),
    @NamedQuery(name = "Empleados.findByDireccion", query = "SELECT e FROM Empleados e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empleados.findByFechaNacimiento", query = "SELECT e FROM Empleados e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Empleados.findByEdad", query = "SELECT e FROM Empleados e WHERE e.edad = :edad"),
    @NamedQuery(name = "Empleados.findBySexo", query = "SELECT e FROM Empleados e WHERE e.sexo = :sexo"),
    @NamedQuery(name = "Empleados.findByFechaIngreso", query = "SELECT e FROM Empleados e WHERE e.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Empleados.findByAntiguedad", query = "SELECT e FROM Empleados e WHERE e.antiguedad = :antiguedad")})
public class Empleados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
    @Size(max = 45)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 45)
    @Column(name = "telefono_fijo")
    private String telefonoFijo;
    @Size(max = 45)
    @Column(name = "telefono_movil")
    private String telefonoMovil;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 45)
    @Column(name = "edad")
    private String edad;
    @Size(max = 45)
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Size(max = 45)
    @Column(name = "antiguedad")
    private String antiguedad;
    @ManyToMany(mappedBy = "empleadosList")
    private List<BaseDatos> baseDatosList;
    @ManyToMany(mappedBy = "empleadosList")
    private List<Cursos> cursosList;
    @JoinTable(name = "em_asignacion_proyecto", joinColumns = {
        @JoinColumn(name = "empleados_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "proyectos_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Proyectos> proyectosList;
    @JoinTable(name = "programas_empleados", joinColumns = {
        @JoinColumn(name = "empleados_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "lenguajes_programacion_id", referencedColumnName = "id")})
    @ManyToMany
    private List<LenguajesProgramacion> lenguajesProgramacionList;
    @JoinTable(name = "grados_empleados", joinColumns = {
        @JoinColumn(name = "empleados_id", referencedColumnName = "id"),
        @JoinColumn(name = "grados_academicos_id", referencedColumnName = "id")})
    @ManyToMany
    private List<GradosAcademicos> gradosAcademicosList;
    @JoinTable(name = "so_empleados", joinColumns = {
        @JoinColumn(name = "empleados_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "sistema_operativo_id", referencedColumnName = "id")})
    @ManyToMany
    private List<SistemaOperativo> sistemaOperativoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleados")
    private List<TipoDesarrollador> tipoDesarrolladorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleados")
    private List<Asignaciones> asignacionesList;

    public Empleados() {
    }

    public Empleados(Integer id) {
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    @XmlTransient
    public List<BaseDatos> getBaseDatosList() {
        return baseDatosList;
    }

    public void setBaseDatosList(List<BaseDatos> baseDatosList) {
        this.baseDatosList = baseDatosList;
    }

    @XmlTransient
    public List<Cursos> getCursosList() {
        return cursosList;
    }

    public void setCursosList(List<Cursos> cursosList) {
        this.cursosList = cursosList;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @XmlTransient
    public List<LenguajesProgramacion> getLenguajesProgramacionList() {
        return lenguajesProgramacionList;
    }

    public void setLenguajesProgramacionList(List<LenguajesProgramacion> lenguajesProgramacionList) {
        this.lenguajesProgramacionList = lenguajesProgramacionList;
    }

    @XmlTransient
    public List<GradosAcademicos> getGradosAcademicosList() {
        return gradosAcademicosList;
    }

    public void setGradosAcademicosList(List<GradosAcademicos> gradosAcademicosList) {
        this.gradosAcademicosList = gradosAcademicosList;
    }

    @XmlTransient
    public List<SistemaOperativo> getSistemaOperativoList() {
        return sistemaOperativoList;
    }

    public void setSistemaOperativoList(List<SistemaOperativo> sistemaOperativoList) {
        this.sistemaOperativoList = sistemaOperativoList;
    }

    @XmlTransient
    public List<TipoDesarrollador> getTipoDesarrolladorList() {
        return tipoDesarrolladorList;
    }

    public void setTipoDesarrolladorList(List<TipoDesarrollador> tipoDesarrolladorList) {
        this.tipoDesarrolladorList = tipoDesarrolladorList;
    }

    @XmlTransient
    public List<Asignaciones> getAsignacionesList() {
        return asignacionesList;
    }

    public void setAsignacionesList(List<Asignaciones> asignacionesList) {
        this.asignacionesList = asignacionesList;
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
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Empleados[ id=" + id + " ]";
    }
    
}
