/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Logica.EmpleadoLogicaLocal;
import Modelo.Empleados;
import javax.faces.bean.RequestScoped;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author usuario
 */
@Named(value = "loginVista")
@RequestScoped
public class loginVista {

    @EJB
    private EmpleadoLogicaLocal empleadoLogica;
    
    private InputText txtNssEmpleado;
    private Password txtClaveEmpleado;
    private CommandButton btnIngresar;
    
    public loginVista() {
    }

    public InputText getTxtNssEmpleado() {
        return txtNssEmpleado;
    }

    public void setTxtNssEmpleado(InputText txtNssEmpleado) {
        this.txtNssEmpleado = txtNssEmpleado;
    }

    public Password getTxtClaveEmpleado() {
        return txtClaveEmpleado;
    }

    public void setTxtClaveEmpleado(Password txtClaveEmpleado) {
        this.txtClaveEmpleado = txtClaveEmpleado;
    }    

    public CommandButton getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(CommandButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }
    
    public void ingresar() {
        try {
         
            
         
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", 
                            ex.getMessage()));
            Logger.getLogger(loginVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void cerrarSesion(){
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().remove("Empleado");
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("../index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(loginVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
