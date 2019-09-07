/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.ProyectoLogicaLocal;
import Modelo.Proyectos;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;


@ManagedBean
@RequestScoped
public class proyectoVista {

    @EJB
    ProyectoLogicaLocal ProyectoLogica;
    
    private List<Proyectos> listaProyecto;
    private InputText txtCodigo;
    private InputText txtNombre;
    private InputText txtArea;
    private Timestamp txtFecha;
    private Date txtFechaAsignacion;
    private Date txtFechaLiberacion;
    private Date txtFechaFases;
    private Float txtCostoTotal;
    private CommandButton Registrar;
    private CommandButton Modificar;
    private Proyectos selectedProyecto;

    public List<Proyectos> getListaProyecto() {
        listaProyecto = ProyectoLogica.consultaProyectos();
        return listaProyecto;
    }

    public void setListaProyecto(List<Proyectos> listaProyecto) {
        this.listaProyecto = listaProyecto;
    }

    public InputText getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(InputText txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtArea() {
        return txtArea;
    }

    public void setTxtArea(InputText txtArea) {
        this.txtArea = txtArea;
    }

    public Timestamp getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(Timestamp txtFecha) {
        this.txtFecha = txtFecha;
    }

    public Date getTxtFechaAsignacion() {
        return txtFechaAsignacion;
    }

    public void setTxtFechaAsignacion(Date txtFechaAsignacion) {
        this.txtFechaAsignacion = txtFechaAsignacion;
    }

    public Date getTxtFechaLiberacion() {
        return txtFechaLiberacion;
    }

    public void setTxtFechaLiberacion(Date txtFechaLiberacion) {
        this.txtFechaLiberacion = txtFechaLiberacion;
    }

    public Date getTxtFechaFases() {
        return txtFechaFases;
    }

    public void setTxtFechaFases(Date txtFechaFases) {
        this.txtFechaFases = txtFechaFases;
    }

    public Float getTxtCostoTotal() {
        return txtCostoTotal;
    }

    public void setTxtCostoTotal(Float txtCostoTotal) {
        this.txtCostoTotal = txtCostoTotal;
    }

    public Proyectos getSelectedProyecto() {
        return selectedProyecto;
    }

    public void setSelectedProyecto(Proyectos selectedProyecto) {
        this.selectedProyecto = selectedProyecto;
    }

    public ProyectoLogicaLocal getProyectoLogica() {
        return ProyectoLogica;
    }

    public void setProyectoLogica(ProyectoLogicaLocal ProyectoLogica) {
        this.ProyectoLogica = ProyectoLogica;
    }

    public List<Proyectos> getListaGradosA() {
        return listaProyecto;
    }

    public void setListaGradosA(List<Proyectos> listaProyecto) {
        this.listaProyecto = listaProyecto;
    }


    public CommandButton getRegistrar() {
        return Registrar;
    }

    public void setRegistrar(CommandButton Registrar) {
        this.Registrar = Registrar;
    }

    public CommandButton getModificar() {
        return Modificar;
    }

    public void setModificar(CommandButton Modificar) {
        this.Modificar = Modificar;
    }

    public Proyectos getSelectedGradosA() {
        return selectedProyecto;
    }

    public void setSelectedGradosA(Proyectos selectedProyecto) {
        this.selectedProyecto = selectedProyecto;
    }
    
    public proyectoVista() {
        
    }
    
    public void seleccionarProyecto(SelectEvent e){
        selectedProyecto = (Proyectos) e.getObject();
        txtCodigo.setValue(selectedProyecto.getCodigo());
        txtNombre.setValue(selectedProyecto.getNombre());
        txtArea.setValue(selectedProyecto.getArea());
        //txtFecha.setValue(selectedProyecto.getFecha());
        //txtFechaAsignacion.setValue(selectedProyecto.getFechaAsignacion());
        //txtFechaFases.setValue(selectedProyecto.getFechaFases());
        //txtFechaLiberacion.setValue(selectedProyecto.getFechaLiberacion());
        //txtCostoTotal.(selectedProyecto.getCostoTotal());
    }
    
     public void registrarProyecto() {
      try {
        Proyectos nuevoproyecto = new Proyectos();
        nuevoproyecto.setCodigo(txtCodigo.getValue().toString());
        nuevoproyecto.setNombre(txtNombre.getValue().toString());
        nuevoproyecto.setArea(txtArea.getValue().toString());
        nuevoproyecto.setFecha(txtFecha);
        nuevoproyecto.setFechaLiberacion(txtFechaLiberacion);
        nuevoproyecto.setFechaAsignacion(txtFechaAsignacion);
        nuevoproyecto.setFechaFases(txtFechaFases);
        nuevoproyecto.setCostoTotal(txtCostoTotal);
        ProyectoLogica.registrarProyectos(nuevoproyecto);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "El Proyecto  se ha Registrado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(proyectoVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
      public void modificarProyecto() {
      try {
        Proyectos nuevoproyecto = new Proyectos();
        nuevoproyecto.setCodigo(txtCodigo.getValue().toString());
        nuevoproyecto.setNombre(txtNombre.getValue().toString());
        nuevoproyecto.setArea(txtArea.getValue().toString());
        nuevoproyecto.setFecha(txtFecha);
        nuevoproyecto.setFechaLiberacion(txtFechaLiberacion);
        nuevoproyecto.setFechaAsignacion(txtFechaAsignacion);
        nuevoproyecto.setFechaFases(txtFechaFases);
        nuevoproyecto.setCostoTotal(txtCostoTotal);
        ProyectoLogica.modificarProyectos(nuevoproyecto);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "El Proyecto  se ha modificado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(proyectoVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
        public void eliminarProyecto() {
      try {
       
        ProyectoLogica.eliminarProyectos(selectedProyecto);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "El Proyecto se ha Eliminado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(proyectoVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }  
}
