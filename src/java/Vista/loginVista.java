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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Logica.EmpleadoLogicaLocal;
import Modelo.Empleados;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

@ManagedBean
@RequestScoped
public class loginVista {

    @EJB
    private EmpleadoLogicaLocal empleadoLogica;

    private InputText txtCedulaEmpleado;
    private Password txtNombreEmpleado;
    private CommandButton btnIngresar;

    public EmpleadoLogicaLocal getEmpleadoLogica() {
        return empleadoLogica;
    }

    public void setEmpleadoLogica(EmpleadoLogicaLocal empleadoLogica) {
        this.empleadoLogica = empleadoLogica;
    }

    public InputText getTxtCedulaEmpleado() {
        return txtCedulaEmpleado;
    }

    public void setTxtCedulaEmpleado(InputText txtCedulaEmpleado) {
        this.txtCedulaEmpleado = txtCedulaEmpleado;
    }

    public Password getTxtNombreEmpleado() {
        return txtNombreEmpleado;
    }

    public void setTxtNombreEmpleado(Password txtNombreEmpleado) {
        this.txtNombreEmpleado = txtNombreEmpleado;
    }

    public loginVista() {
    }

    public CommandButton getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(CommandButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }

    public void ingresar() {
        try {
            Empleados nuevoEmpleado = new Empleados();
            nuevoEmpleado.setNombre(txtNombreEmpleado.getValue().toString());
            nuevoEmpleado.setCedula(txtCedulaEmpleado.getValue().toString());
            Empleados empleadoLogueado = empleadoLogica.ingresar(nuevoEmpleado);

            //Guarda al usuario que se carga en la sesion.
            FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().put("Empleado", empleadoLogueado);

            //Redirecciono a la pagina deseada
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("Principal/principal.xhtml");

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(loginVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cerrarSesion() {
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
