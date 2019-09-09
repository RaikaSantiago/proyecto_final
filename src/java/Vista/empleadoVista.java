/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.EmpleadoLogicaLocal;
import Logica.Tipo_DesarrolladorLogicaLocal;
import Modelo.Empleados;
import Modelo.TipoDesarrollador;
import java.util.ArrayList;
import java.util.Date;
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
public class empleadoVista {

    @EJB
    EmpleadoLogicaLocal empleadoLogica;
    
    @EJB
    Tipo_DesarrolladorLogicaLocal desarrolloLogica;


    private List<Empleados> listaEmpleados;
    private List<TipoDesarrollador> listaTipoDesarrollador;
    //private InputText txtId;
    private InputText txtNombre;
    private InputText txtApellidos;
    private InputText txtEmail;
    private InputText txtCedula;
    private InputText txtTelefonoFijo;
    private InputText txtTelefonoMovil;
    private InputText txtDireccion;
    private Date FechaNacimiento;
    private InputText txtEdad;
    private InputText txtSexo;
    private Date FechaIngreso;
    private InputText txtAntiguedad;
    private InputText txtClave;
    private SelectOneMenu Desarrollador;
    private ArrayList<SelectItem> itemDesarrollador;
    private Empleados selectedEmpleado;
    private CommandButton Registrar;
    private CommandButton Modificar;
    private CommandButton Eliminar;
    
    public List<Empleados> getListaEmpleados() {
        listaEmpleados = empleadoLogica.consultaEmpleados();
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public InputText getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(InputText txtClave) {
        this.txtClave = txtClave;
    }

    public Tipo_DesarrolladorLogicaLocal getDesarrolloLogica() {
        return desarrolloLogica;
    }

    public void setDesarrolloLogica(Tipo_DesarrolladorLogicaLocal desarrolloLogica) {
        this.desarrolloLogica = desarrolloLogica;
    }

    public SelectOneMenu getDesarrollador() {
        return Desarrollador;
    }

    public void setDesarrollador(SelectOneMenu Desarrollador) {
        this.Desarrollador = Desarrollador;
    }

    public ArrayList<SelectItem> getItemDesarrollador() {
        itemDesarrollador = new ArrayList<>();
        for(int i = 0; i < getListaTipoDesarrollador().size(); i++){
            itemDesarrollador.add(new SelectItem(getListaTipoDesarrollador().get(i).getId().toString(), getListaTipoDesarrollador().get(i).getNombreCargo()));
        }
        return itemDesarrollador;
    }

    public void setItemDesarrollador(ArrayList<SelectItem> itemDesarrollador) {
        this.itemDesarrollador = itemDesarrollador;
    }

    public List<TipoDesarrollador> getListaTipoDesarrollador() {
        return listaTipoDesarrollador;
    }

    public void setListaTipoDesarrollador(List<TipoDesarrollador> listaTipoDesarrollador) {
        this.listaTipoDesarrollador = listaTipoDesarrollador;
    }


    
    

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtApellidos() {
        return txtApellidos;
    }

    public void setTxtApellidos(InputText txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public InputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(InputText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public InputText getTxtCedula() {
        return txtCedula;
    }

    public void setTxtCedula(InputText txtCedula) {
        this.txtCedula = txtCedula;
    }

    public InputText getTxtTelefonoFijo() {
        return txtTelefonoFijo;
    }

    public void setTxtTelefonoFijo(InputText txtTelefonoFijo) {
        this.txtTelefonoFijo = txtTelefonoFijo;
    }

    public InputText getTxtTelefonoMovil() {
        return txtTelefonoMovil;
    }

    public void setTxtTelefonoMovil(InputText txtTelefonoMovil) {
        this.txtTelefonoMovil = txtTelefonoMovil;
    }

    public InputText getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(InputText txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public InputText getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(InputText txtEdad) {
        this.txtEdad = txtEdad;
    }

    public InputText getTxtSexo() {
        return txtSexo;
    }

    public void setTxtSexo(InputText txtSexo) {
        this.txtSexo = txtSexo;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public InputText getTxtAntiguedad() {
        return txtAntiguedad;
    }

    public void setTxtAntiguedad(InputText txtAntiguedad) {
        this.txtAntiguedad = txtAntiguedad;
    }

    public Empleados getSelectedEmpleado() {
        return selectedEmpleado;
    }

    public void setSelectedEmpleado(Empleados selectedEmpleado) {
        this.selectedEmpleado = selectedEmpleado;
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

    public CommandButton getEliminar() {
        return Eliminar;
    }

    public void setEliminar(CommandButton Eliminar) {
        this.Eliminar = Eliminar;
    }
    
    

    public empleadoVista() {
    }

    public void seleccionarEmpleado(SelectEvent e) {
        selectedEmpleado = (Empleados) e.getObject();
       // txtId.setValue(selectedEmpleado.getId());
        txtNombre.setValue(selectedEmpleado.getNombre());
        txtApellidos.setValue(selectedEmpleado.getApellidos());
        txtCedula.setValue(selectedEmpleado.getCedula());
        txtEmail.setValue(selectedEmpleado.getEmail());
        txtDireccion.setValue(selectedEmpleado.getDireccion());
        //FechaNacimiento.after(selectedEmpleado.getFechaNacimiento());
        txtEdad.setValue(selectedEmpleado.getEdad());
        txtSexo.setValue(selectedEmpleado.getSexo());
        //FechaIngreso.after(selectedEmpleado.getFechaIngreso()); 
        txtTelefonoFijo.setValue(selectedEmpleado.getTelefonoFijo());
        txtTelefonoMovil.setValue(selectedEmpleado.getTelefonoMovil());
        txtAntiguedad.setValue(selectedEmpleado.getAntiguedad());
        txtClave.setValue(selectedEmpleado.getClave());
        
    }

    public void registrarEmpleado() {
        try {
            Empleados nuevoEmpleado = new Empleados();
            TipoDesarrollador nuevoDesarrollador = new TipoDesarrollador();
           // nuevoEmpleado.setId(Integer.parseInt(txtId.getValue().toString()));
            nuevoEmpleado.setNombre(txtNombre.getValue().toString());
            nuevoEmpleado.setApellidos(txtApellidos.getValue().toString());
            nuevoEmpleado.setEmail(txtEmail.getValue().toString());
            nuevoEmpleado.setCedula(txtCedula.getValue().toString());
            nuevoEmpleado.setTelefonoFijo(txtTelefonoFijo.getValue().toString());
            nuevoEmpleado.setTelefonoMovil(txtTelefonoMovil.getValue().toString());
            nuevoEmpleado.setDireccion(txtDireccion.getValue().toString());
            nuevoEmpleado.setFechaNacimiento(FechaNacimiento);
            nuevoEmpleado.setEdad(txtEdad.getValue().toString());
            nuevoEmpleado.setSexo(txtSexo.getValue().toString());
            nuevoEmpleado.setFechaIngreso(FechaIngreso);
            nuevoEmpleado.setAntiguedad(txtAntiguedad.getValue().toString());
            nuevoEmpleado.setClave(txtClave.getValue().toString());
            
            nuevoDesarrollador = desarrolloLogica.buscarTipo(Integer.parseInt(Desarrollador.getValue().toString()));
            nuevoEmpleado.setTipoDesarrolladorId(nuevoDesarrollador); 
            
            empleadoLogica.registrarEmpleado(nuevoEmpleado);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Empleado Registrado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(empleadoVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Empleados> getListaEmpleado() {
        listaEmpleados = empleadoLogica.consultaEmpleados();
        return listaEmpleados;
    }

    public void setListaEmpleado(List<Empleados> listaEmpleado) {
        this.listaEmpleados = listaEmpleado;
    }


    
    
    public void modificarEmpleado() {
        try {
            Empleados nuevoEmpleado = selectedEmpleado;
            TipoDesarrollador nuevoDesarrollador = new TipoDesarrollador();
            //nuevoEmpleado.setId(Integer.parseInt(txtId.getValue().toString()));
            nuevoEmpleado.setNombre(txtNombre.getValue().toString());
            nuevoEmpleado.setApellidos(txtApellidos.getValue().toString());
            nuevoEmpleado.setEmail(txtEmail.getValue().toString());
            nuevoEmpleado.setCedula(txtCedula.getValue().toString());
            nuevoEmpleado.setTelefonoFijo(txtTelefonoFijo.getValue().toString());
            nuevoEmpleado.setTelefonoMovil(txtTelefonoMovil.getValue().toString());
            nuevoEmpleado.setDireccion(txtDireccion.getValue().toString());
            nuevoEmpleado.setFechaNacimiento(FechaNacimiento);
            nuevoEmpleado.setEdad(txtEdad.getValue().toString());
            nuevoEmpleado.setSexo(txtSexo.getValue().toString());
            nuevoEmpleado.setFechaIngreso(FechaIngreso);
            nuevoEmpleado.setAntiguedad(txtAntiguedad.getValue().toString());
            nuevoEmpleado.setClave(txtClave.getValue().toString());
            
            nuevoDesarrollador = desarrolloLogica.buscarTipo(Integer.parseInt(Desarrollador.getValue().toString()));
            nuevoEmpleado.setTipoDesarrolladorId(nuevoDesarrollador);

            empleadoLogica.modificarEmpleado(nuevoEmpleado);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Empleado Modificado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(empleadoVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarEmpleado() {
        try {
           
            empleadoLogica.eliminarEmpleado(selectedEmpleado);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Empleado Eliminado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(empleadoVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
