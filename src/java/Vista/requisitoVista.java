/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author usuario
 */
@Named(value = "requisitoVista")
@RequestScoped
public class requisitoVista {

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
        this.estadoRequisito = estadoRequisito;
    }
    
    
}
