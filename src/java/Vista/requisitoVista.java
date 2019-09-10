/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.RequisitoLogicaLocal;
import Modelo.Requisito;
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
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

@ManagedBean
@RequestScoped
public class requisitoVista {

    @EJB
    private RequisitoLogicaLocal requisitoLogica;

    private List<Requisito> listaRequisito;
    private Requisito selectedRequisito;
    private CommandButton registrarRequisito;
    private CommandButton modificarRequisito;
    private CommandButton eliminarRequisito;
    private InputText descripcionRequisito;
    private InputText tipoRequisito;
    private SelectOneMenu estadoRequisito;

    public requisitoVista() {
    }

    public List<Requisito> getListaRequisito() {
        listaRequisito = requisitoLogica.consultaRequisito();
        return listaRequisito;
    }

    public void setListaRequisito(List<Requisito> listaRequisito) {
        this.listaRequisito = listaRequisito;
    }

    public Requisito getSelectedRequisito() {
        return selectedRequisito;
    }

    public void setSelectedRequisito(Requisito selectedRequisito) {
        this.selectedRequisito = selectedRequisito;
    }

    public CommandButton getRegistrarRequisito() {
        return registrarRequisito;
    }

    public void setRegistrarRequisito(CommandButton registrarRequisito) {
        this.registrarRequisito = registrarRequisito;
    }

    public CommandButton getModificarRequisito() {
        return modificarRequisito;
    }

    public void setModificarRequisito(CommandButton modificarRequisito) {
        this.modificarRequisito = modificarRequisito;
    }

    public CommandButton getEliminarRequisito() {
        return eliminarRequisito;
    }

    public void setEliminarRequisito(CommandButton eliminarRequisito) {
        this.eliminarRequisito = eliminarRequisito;
    }

    public InputText getDescripcionRequisito() {
        return descripcionRequisito;
    }

    public void setDescripcionRequisito(InputText descripcionRequisito) {
        this.descripcionRequisito = descripcionRequisito;
    }

    public InputText getTipoRequisito() {
        return tipoRequisito;
    }

    public void setTipoRequisito(InputText tipoRequisito) {
        this.tipoRequisito = tipoRequisito;
    }

    public SelectOneMenu getEstadoRequisito() {
        return estadoRequisito;
    }

    public void setEstadoRequisito(SelectOneMenu estadoRequisito) {
        this.estadoRequisito = estadoRequisito;
    }

    public void seleccionarRequisito(SelectEvent e) {
        selectedRequisito = (Requisito) e.getObject();
        descripcionRequisito.setValue(selectedRequisito.getDescripcion());
        tipoRequisito.setValue(selectedRequisito.getTipo());
        estadoRequisito.setValue(selectedRequisito.getEstado());
    }

    public void registrarRequisito() {
        try {
            Requisito nuevoRequisito = new Requisito();
            nuevoRequisito.setDescripcion(descripcionRequisito.getValue().toString());
            nuevoRequisito.setTipo(tipoRequisito.getValue().toString());
            nuevoRequisito.setEstado(estadoRequisito.getValue().toString());
            requisitoLogica.registrarRequisito(nuevoRequisito);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El requisito se registro correctamente!"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(requisitoContenidoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarRequisito() {
        try {
            Requisito nuevoRequisito = selectedRequisito;
            nuevoRequisito.setDescripcion(descripcionRequisito.getValue().toString());
            nuevoRequisito.setTipo(tipoRequisito.getValue().toString());
            nuevoRequisito.setEstado(estadoRequisito.getValue().toString());
            requisitoLogica.modificarRequisito(nuevoRequisito);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El requisito modificado correctamente!"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(requisitoVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarRequisito() {
        try {
            requisitoLogica.eliminarRequisito(selectedRequisito);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El requisito fue eliminado correctamente!"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(requisitoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
