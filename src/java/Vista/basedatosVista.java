/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Base_DatosLogicaLocal;
import Modelo.BaseDatos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

@ManagedBean
@RequestScoped
public class basedatosVista {

    @EJB
    Base_DatosLogicaLocal baseDatosLogica;

    private List<BaseDatos> listaBaseDatos;
    private InputText txtId;
    private InputText txtNombre;
    private InputText txtTipo;
    private CommandButton Registrar;
    private CommandButton Modificar;
    private CommandButton Eliminar;
    private BaseDatos selectedDB;

    public basedatosVista() {
    }

    public InputText getTxtId() {
        return txtId;
    }

    public void setTxtId(InputText txtId) {
        this.txtId = txtId;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(InputText txtTipo) {
        this.txtTipo = txtTipo;
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

    public List<BaseDatos> getListaBaseDatos() {
        listaBaseDatos = baseDatosLogica.consultaBaseDatos();
        return listaBaseDatos;
    }

    public void setListaBaseDatos(List<BaseDatos> listaBaseDatos) {
        this.listaBaseDatos = listaBaseDatos;
    }

    public BaseDatos getSelectedDB() {
        return selectedDB;
    }

    public void setSelectedDB(BaseDatos selectedDB) {
        this.selectedDB = selectedDB;
    }

    public CommandButton getEliminar() {
        return Eliminar;
    }

    public void setEliminar(CommandButton Eliminar) {
        this.Eliminar = Eliminar;
    }

    public void seleccionarBaseDeDatos(SelectEvent e) {
        selectedDB = (BaseDatos) e.getObject();
        txtNombre.setValue(selectedDB.getNombre());
        txtTipo.setValue(selectedDB.getTipo());
    }

    public void registrarDB() {
        try {
            BaseDatos nuevaDB = new BaseDatos();
            nuevaDB.setNombre(txtNombre.getValue().toString());
            nuevaDB.setTipo(txtTipo.getValue().toString());

            baseDatosLogica.registrarBaseDatos(nuevaDB);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Base de Datos Registrada Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Registrar",
                            ex.getMessage()));
            Logger.getLogger(basedatosVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarDB() {
        try {
            BaseDatos nuevaDB = selectedDB;
            nuevaDB.setNombre(txtNombre.getValue().toString());
            nuevaDB.setTipo(txtTipo.getValue().toString());

            baseDatosLogica.modificarBaseDatos(nuevaDB);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Base de Datos Modificada Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(basedatosVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarDB() {
        try {

            baseDatosLogica.eliminarBaseDatos(selectedDB);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Base de Datos Eliminada Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(basedatosVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
