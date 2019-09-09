/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.UniversidadLogicaLocal;
import Modelo.Universidad;
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
public class universidadVista {

    @EJB
    UniversidadLogicaLocal universidadLogica;

    private List<Universidad> listaUniversidad;
    private InputText txtID;
    private InputText txtNombre;
    private Date FechaGrado;
    private InputText txtTitulo;
    private Universidad selectedUni;
    private CommandButton Registrar;
    private CommandButton Modificar;
    private CommandButton Eliminar;

    public List<Universidad> getListaUniversidad() {
        listaUniversidad = universidadLogica.consultaUniversidad();
        return listaUniversidad;
    }

    public void setListaUniversidad(List<Universidad> listaUniversidad) {
        this.listaUniversidad = listaUniversidad;
    }

    public InputText getTxtID() {
        return txtID;
    }

    public void setTxtID(InputText txtID) {
        this.txtID = txtID;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public Date getFechaGrado() {
        return FechaGrado;
    }

    public void setFechaGrado(Date FechaGrado) {
        this.FechaGrado = FechaGrado;
    }

    public InputText getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(InputText txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public Universidad getSelectedUni() {
        return selectedUni;
    }

    public void setSelectedUni(Universidad selectedUni) {
        this.selectedUni = selectedUni;
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

    public universidadVista() {
    }

    public void seleccionarUniversidad(SelectEvent e) {
        selectedUni = (Universidad) e.getObject();
        txtNombre.setValue(selectedUni.getNombre());
        txtTitulo.setValue(selectedUni.getTitulo());
        //FechaGrado.toString(Integer.parseInt(selectedUni.getFechaGrado()));
    }

    public void registrarUniversidad() {
        try {
            Universidad nuevaUni = new Universidad();
            nuevaUni.setNombre(txtNombre.getValue().toString());
            nuevaUni.setFechaGrado(FechaGrado);
            nuevaUni.setTitulo(txtTitulo.getValue().toString());
            universidadLogica.registrarUniversidad(nuevaUni);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Universidad Registrada Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al registrar",
                            ex.getMessage()));
            Logger.getLogger(universidadVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarUniversidad() {

        try {
            Universidad nuevaUni = selectedUni ;
            nuevaUni.setNombre(txtNombre.getValue().toString());
            nuevaUni.setFechaGrado(FechaGrado);
            nuevaUni.setTitulo(txtTitulo.getValue().toString());
            universidadLogica.modificarUniversidad(nuevaUni);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Universidad Modificada Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al modificar",
                            ex.getMessage()));
            Logger.getLogger(universidadVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
