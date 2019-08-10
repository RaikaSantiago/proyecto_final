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
@Named(value = "requisitosVista")
@RequestScoped
public class requisitosVista {

    private CommandButton registrarRequisito;
    private CommandButton eliminarRequisito;
    private CommandButton registrarRC;
    private CommandButton eliminarRC;
    private CommandButton ampliacionRC;
    private CommandButton redeuccionRC;
    private CommandButton cambioRC;
    private InputText descripcionRequisito;
    private InputText descripcionRC;
    private InputText tipoRequisito;
    private InputText tipoRC;
    private InputText estadoRequisito;
    private InputText estadoRC;
    private InputText nombreProyectoRC;
    private InputText numeroSolicitudRC;
    private InputText tituloRC;
    private InputText fechaRC;
    private InputText solicitanteRC;
    private InputText origenRC;
    private InputText prioridadSolicitanteRC;
    private InputText prioridadRealizacionRC;
    private InputText verificadorRC;
    private InputText fechaUltimaActualizacionRC;
    private InputText releaseRC;
    private InputText esfuerzoRC;
    private InputText comentariosRC;
    
    public requisitosVista() {
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

    public CommandButton getRegistrarRC() {
        return registrarRC;
    }

    public void setRegistrarRC(CommandButton registrarRC) {
        this.registrarRC = registrarRC;
    }

    public CommandButton getEliminarRC() {
        return eliminarRC;
    }

    public void setEliminarRC(CommandButton eliminarRC) {
        this.eliminarRC = eliminarRC;
    }

    public CommandButton getAmpliacionRC() {
        return ampliacionRC;
    }

    public void setAmpliacionRC(CommandButton ampliacionRC) {
        this.ampliacionRC = ampliacionRC;
    }

    public CommandButton getRedeuccionRC() {
        return redeuccionRC;
    }

    public void setRedeuccionRC(CommandButton redeuccionRC) {
        this.redeuccionRC = redeuccionRC;
    }

    public CommandButton getCambioRC() {
        return cambioRC;
    }

    public void setCambioRC(CommandButton cambioRC) {
        this.cambioRC = cambioRC;
    }

    public InputText getDescripcionRequisito() {
        return descripcionRequisito;
    }

    public void setDescripcionRequisito(InputText descripcionRequisito) {
        this.descripcionRequisito = descripcionRequisito;
    }

    public InputText getDescripcionRC() {
        return descripcionRC;
    }

    public void setDescripcionRC(InputText descripcionRC) {
        this.descripcionRC = descripcionRC;
    }

    public InputText getTipoRequisito() {
        return tipoRequisito;
    }

    public void setTipoRequisito(InputText tipoRequisito) {
        this.tipoRequisito = tipoRequisito;
    }

    public InputText getTipoRC() {
        return tipoRC;
    }

    public void setTipoRC(InputText tipoRC) {
        this.tipoRC = tipoRC;
    }

    public InputText getEstadoRequisito() {
        return estadoRequisito;
    }

    public void setEstadoRequisito(InputText estadoRequisito) {
        this.estadoRequisito = estadoRequisito;
    }

    public InputText getEstadoRC() {
        return estadoRC;
    }

    public void setEstadoRC(InputText estadoRC) {
        this.estadoRC = estadoRC;
    }

    public InputText getNombreProyectoRC() {
        return nombreProyectoRC;
    }

    public void setNombreProyectoRC(InputText nombreProyectoRC) {
        this.nombreProyectoRC = nombreProyectoRC;
    }

    public InputText getNumeroSolicitudRC() {
        return numeroSolicitudRC;
    }

    public void setNumeroSolicitudRC(InputText numeroSolicitudRC) {
        this.numeroSolicitudRC = numeroSolicitudRC;
    }

    public InputText getTituloRC() {
        return tituloRC;
    }

    public void setTituloRC(InputText tituloRC) {
        this.tituloRC = tituloRC;
    }

    public InputText getFechaRC() {
        return fechaRC;
    }

    public void setFechaRC(InputText fechaRC) {
        this.fechaRC = fechaRC;
    }

    public InputText getSolicitanteRC() {
        return solicitanteRC;
    }

    public void setSolicitanteRC(InputText solicitanteRC) {
        this.solicitanteRC = solicitanteRC;
    }

    public InputText getOrigenRC() {
        return origenRC;
    }

    public void setOrigenRC(InputText origenRC) {
        this.origenRC = origenRC;
    }

    public InputText getPrioridadSolicitanteRC() {
        return prioridadSolicitanteRC;
    }

    public void setPrioridadSolicitanteRC(InputText prioridadSolicitanteRC) {
        this.prioridadSolicitanteRC = prioridadSolicitanteRC;
    }

    public InputText getPrioridadRealizacionRC() {
        return prioridadRealizacionRC;
    }

    public void setPrioridadRealizacionRC(InputText prioridadRealizacionRC) {
        this.prioridadRealizacionRC = prioridadRealizacionRC;
    }

    public InputText getVerificadorRC() {
        return verificadorRC;
    }

    public void setVerificadorRC(InputText verificadorRC) {
        this.verificadorRC = verificadorRC;
    }

    public InputText getFechaUltimaActualizacionRC() {
        return fechaUltimaActualizacionRC;
    }

    public void setFechaUltimaActualizacionRC(InputText fechaUltimaActualizacionRC) {
        this.fechaUltimaActualizacionRC = fechaUltimaActualizacionRC;
    }

    public InputText getReleaseRC() {
        return releaseRC;
    }

    public void setReleaseRC(InputText releaseRC) {
        this.releaseRC = releaseRC;
    }

    public InputText getEsfuerzoRC() {
        return esfuerzoRC;
    }

    public void setEsfuerzoRC(InputText esfuerzoRC) {
        this.esfuerzoRC = esfuerzoRC;
    }

    public InputText getComentariosRC() {
        return comentariosRC;
    }

    public void setComentariosRC(InputText comentariosRC) {
        this.comentariosRC = comentariosRC;
    }
    
}
