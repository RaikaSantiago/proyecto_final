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
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;


@ManagedBean
@RequestScoped
public class requisitoVista {

    private RequisitoLogicaLocal requisitoLogica;
    
    private List<Requisito> listaRequisito;
    private Requisito selectedRequisito;
    private CommandButton registrarRequisito;
    private CommandButton eliminarRequisito;
    private InputText descripcionRequisito;
    private InputText tipoRequisito;
    private InputText estadoRequisito;
    
    public requisitoVista() {
    }

    public CommandButton getRegistrarRequisito() {
        return registrarRequisito;
    }

    public void setRegistrarRequisito(CommandButton registrarRequisito) {
        this.registrarRequisito = registrarRequisito;
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

    public InputText getEstadoRequisito() {
        return estadoRequisito;
    }

    public void setEstadoRequisito(InputText estadoRequisito) {
        listaRequisito = requisitoLogica.consultaRequisito();
        this.estadoRequisito = estadoRequisito;
    }

    public List<Requisito> getListaRequisito() {
        return listaRequisito;
    }

    public void setListaRequisito(List<Requisito> listaRequisito) {
        this.listaRequisito = listaRequisito;
    }
    
    public void seleccionarRequisito(SelectEvent e){
        selectedRequisito = (Requisito) e.getObject();
        descripcionRequisito.setValue(selectedRequisito.getDescripcion());
        tipoRequisito.setValue(selectedRequisito.getTipo());
        estadoRequisito.setValue(selectedRequisito.getEstado());
    }
    
    public void registrarRequisito(){
        try {
            Requisito nuevoRequisito = new Requisito();
            nuevoRequisito.setDescripcion(descripcionRequisito.getValue().toString());
            nuevoRequisito.setTipo(tipoRequisito.getValue().toString());
            nuevoRequisito.setEstado(estadoRequisito.getValue().toString());
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
}
