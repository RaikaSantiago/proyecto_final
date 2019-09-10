/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.AsignacionesLogicaLocal;
import Logica.EmpleadoLogicaLocal;
import Modelo.Asignaciones;
import Modelo.AsignacionesPK;
import Modelo.Empleados;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

@ManagedBean
@RequestScoped
public class asignacionesVista {

    @EJB
    private AsignacionesLogicaLocal asignacionesLogica;
    
    @EJB
    private EmpleadoLogicaLocal empleadoLogica;

    private List<Asignaciones> listaAsignaciones;
    private List<Empleados> listaEmpleados;
    private InputText txthoras;
    private InputText txtpresupuesto;
    private InputText txtcantidad_proyectos;
    private InputText txtId;
    private SelectOneMenu txtEmpleado;
    private ArrayList<SelectItem> itemEmpleado;
    private Asignaciones selectedAsignacion;
    private CommandButton Registrar;
    private CommandButton Modificar;

    public asignacionesVista() {
    }

    public AsignacionesLogicaLocal getAsignacionesLogica() {
        return asignacionesLogica;
    }

    public void setAsignacionesLogica(AsignacionesLogicaLocal asignacionesLogica) {
        this.asignacionesLogica = asignacionesLogica;
    }

    public List<Asignaciones> getListaAsignaciones() {
        listaAsignaciones = asignacionesLogica.consultaAsignaciones();
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


    public SelectOneMenu getTxtEmpleado() {
        return txtEmpleado;
    }

    public void setTxtEmpleado(SelectOneMenu txtEmpleado) {
        this.txtEmpleado = txtEmpleado;
    }

    public List<Empleados> getListaEmpleados() {
        listaEmpleados = empleadoLogica.consultaEmpleados();
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public ArrayList<SelectItem> getItemEmpleado() {
        itemEmpleado = new ArrayList<>();
        for (int i = 0; i < getListaEmpleados().size(); i++) {
            itemEmpleado.add(new SelectItem(getListaEmpleados().get(i).getId().toString(),
                                            getListaEmpleados().get(i).getNombre() + ' ' + getListaEmpleados().get(i).getApellidos() ));
            
        }
        return itemEmpleado;
        
    }

    public void setItemEmpleado(ArrayList<SelectItem> itemEmpleado) {
        this.itemEmpleado = itemEmpleado;
    }

    public Asignaciones getSelectedAsignacion() {
        return selectedAsignacion;
    }

    public void setSelectedAsignacion(Asignaciones selectedAsignacion) {
        this.selectedAsignacion = selectedAsignacion;
    }
    
    
    

    public void seleccionarAsignaciones(SelectEvent e) {
        selectedAsignacion = (Asignaciones) e.getObject();
        txthoras.setValue(selectedAsignacion.getHoras());
        txtpresupuesto.setValue(selectedAsignacion.getPresupuestos());
        txtcantidad_proyectos.setValue(selectedAsignacion.getCantidadProyectos());
        txtEmpleado.setValue(selectedAsignacion.getEmpleados());
    }

    public void registrarAsignaciones() {
        try {
            Asignaciones nuevaAsig = new Asignaciones();
            Empleados nuevoEmpleado = new Empleados();
            
            AsignacionesPK nuevoAsiPK = new AsignacionesPK();
            
            nuevoEmpleado = empleadoLogica.buscar(Integer.parseInt(txtEmpleado.getValue().toString()));            
            nuevaAsig.setHoras(Integer.parseInt(txthoras.getValue().toString()));
            nuevaAsig.setCantidadProyectos(Integer.parseInt(txtcantidad_proyectos.getValue().toString()));
            nuevaAsig.setPresupuestos(Float.parseFloat(txtpresupuesto.getValue().toString()));
            
 
            nuevoAsiPK.setEmpleadosId(nuevoEmpleado.getId());
            
            nuevaAsig.setAsignacionesPK(nuevoAsiPK);
            
            
            nuevaAsig.setEmpleados(nuevoEmpleado);
            
             
            
            System.out.println("++++++++++++++++++++++++++++++++++++++"+nuevoEmpleado.getId());
            
            asignacionesLogica.registrarAsignaciones(nuevaAsig);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "La Asignacion se ha Registrado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(asignacionesVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarAsignaciones() {
        try {
            Asignaciones nuevaAsig = selectedAsignacion;
            Empleados nuevoEmpleado = new Empleados();
//            AsignacionesPK nuevoAsiPK = new AsignacionesPK();
            
            nuevaAsig.setHoras(Integer.parseInt(txthoras.getValue().toString()));
            nuevaAsig.setCantidadProyectos(Integer.parseInt(txtcantidad_proyectos.getValue().toString()));
            nuevaAsig.setPresupuestos(Float.parseFloat(txtpresupuesto.getValue().toString()));
            
//            nuevoAsiPK.setEmpleadosId(nuevoEmpleado.getId());
//            
//            nuevaAsig.setAsignacionesPK(nuevoAsiPK);

            nuevoEmpleado = empleadoLogica.buscar(Integer.parseInt(txtEmpleado.getValue().toString()));
            nuevaAsig.setEmpleados(nuevoEmpleado);
            
            asignacionesLogica.modificarAsignaciones(nuevaAsig);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "La asignaciones ha sido Modificada Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(asignacionesVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarAsignaciones() {
        try {

            asignacionesLogica.eliminarAsignaciones(selectedAsignacion);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "La Asignacion ha sido Eliminada Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(asignacionesVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
