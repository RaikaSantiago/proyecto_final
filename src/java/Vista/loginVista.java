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
    private Password txtClave;
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

    public Password getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(Password txtClave) {
        this.txtClave = txtClave;
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
            nuevoEmpleado.setCedula(txtCedulaEmpleado.getValue().toString());
            nuevoEmpleado.setClave(txtClave.getValue().toString());
            Empleados empleadoLogueado = empleadoLogica.Ingresar(nuevoEmpleado);

            //Guarda al usuario que se carga en la sesion.
            FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().put("Empleados", empleadoLogueado);

            //Redirecciono a la pagina deseada
            if (empleadoLogueado.getTipoDesarrolladorId().equals("1")){
                FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("admin/paginaBaseDatos.xhtml");
            }else{
                FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("admin/paginaAsignaciones.xhtml");
            }

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Verificar el nombre y la contraseña",
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
