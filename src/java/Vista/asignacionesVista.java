/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.AsignacionesLogicaLocal;
import Modelo.Asignaciones;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;


@Named(value = "asignacionesVista")
@RequestScoped
public class asignacionesVista {

    @EJB
    private AsignacionesLogicaLocal asignacionesLogica;

    private List<Asignaciones> listaAsignaciones;
    private InputText txthoras;
    private InputText txtpresupuesto;
    private InputText txtcantidad_proyectos;
    private InputText txtId;
    private CommandButton Registrar;
    private CommandButton Modificar;
    private Asignaciones selectedAsig;
    public asignacionesVista() {
    }

    public AsignacionesLogicaLocal getAsignacionesLogica() {
        return asignacionesLogica;
    }

    public void setAsignacionesLogica(AsignacionesLogicaLocal asignacionesLogica) {
        this.asignacionesLogica = asignacionesLogica;
    }

    public List<Asignaciones> getListaAsignaciones() {
        return listaAsignaciones;
    }

    public void setListaAsignaciones(List<Asignaciones> listaAsignaciones) {
        this.listaAsignaciones = listaAsignaciones;
    }

    public InputText getTxthoras() {
        return txthoras;
    }

    public void setTxthoras(InputText txthoras) {
        this.txthoras = txthoras;
    }

    public InputText getTxtpresupuesto() {
        return txtpresupuesto;
    }

    public void setTxtpresupuesto(InputText txtpresupuesto) {
        this.txtpresupuesto = txtpresupuesto;
    }

    public InputText getTxtcantidad_proyectos() {
        return txtcantidad_proyectos;
    }

    public void setTxtcantidad_proyectos(InputText txtcantidad_proyectos) {
        this.txtcantidad_proyectos = txtcantidad_proyectos;
    }

    public InputText getTxtId() {
        return txtId;
    }

    public void setTxtId(InputText txtId) {
        this.txtId = txtId;
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

    public Asignaciones getSelectedAsig() {
        return selectedAsig;
    }

    public void setSelectedAsig(Asignaciones selectedAsig) {
        this.selectedAsig = selectedAsig;
    }
    public void registrarAsignaciones() {
      try {
        Asignaciones nuevaAsig = new Asignaciones();
        nuevaAsig.setHoras(Integer.parseInt(txthoras.getValue().toString()));
        nuevaAsig.setCantidadProyectos(Integer.parseInt(txtcantidad_proyectos.getValue().toString()));
        nuevaAsig.setPresupuestos(Float.parseFloat(txtpresupuesto.getValue().toString()));

        asignacionesLogica.registrarAsignaciones(nuevaAsig);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "La Asignacion  se ha Registrado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(asignacionesVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
    
     public void modificarAsignaciones() {
      try {
        Asignaciones nuevaAsig = new Asignaciones();
        nuevaAsig.setHoras(Integer.parseInt(txthoras.getValue().toString()));
        nuevaAsig.setCantidadProyectos(Integer.parseInt(txtcantidad_proyectos.getValue().toString()));
        nuevaAsig.setPresupuestos(Float.parseFloat(txtpresupuesto.getValue().toString()));
        
        asignacionesLogica.modificarAsignaciones(nuevaAsig);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "La asignaciones ha sido Modificada Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(asignacionesVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
     
       public void eliminarAsignaciones() {
      try {
       
        asignacionesLogica.eliminarAsignaciones(selectedAsig);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "La Asignacion ha sido Eliminada Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(asignacionesVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
}
