/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Requisito_ContenidoLogicaLocal;
import Modelo.RequisitoContenido;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;


@Named(value = "requisitosVista")
@RequestScoped
public class requisitoContenidoVista {

    private Requisito_ContenidoLogicaLocal requisitoContenidoLogica;
    
    private List<RequisitoContenido> listaRequisitoContenido;
    private RequisitoContenido selectedRequisitoContenido;
    private CommandButton registrarRC;
    private CommandButton eliminarRC;
    private CommandButton ampliacionRC;
    private CommandButton redeuccionRC;
    private CommandButton cambioRC;
    private InputText nombreProyectoRC;
    private InputText numeroSolicitudRC;
    private InputText tituloRC;
    private Date fechaRC;
    private InputText solicitanteRC;
    private InputText origenRC;
    private InputText estadoRC;
    private InputText prioridadSolicitanteRC;
    private InputText prioridadRealizacionRC;
    private InputText verificadorRC;
    private Date fechaUltimaActualizacionRC;
    private InputText releaseRC;
    private InputText esfuerzoRC;
    private InputText descripcionRC;
    private InputText comentariosRC;
    
    public requisitoContenidoVista() {
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

    public Date getFechaRC() {
        return fechaRC;
    }

    public void setFechaRC(Date fechaRC) {
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

    public InputText getEstadoRC() {
        return estadoRC;
    }

    public void setEstadoRC(InputText estadoRC) {
        this.estadoRC = estadoRC;
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

    public Date getFechaUltimaActualizacionRC() {
        return fechaUltimaActualizacionRC;
    }

    public void setFechaUltimaActualizacionRC(Date fechaUltimaActualizacionRC) {
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

    public InputText getDescripcionRC() {
        return descripcionRC;
    }

    public void setDescripcionRC(InputText descripcionRC) {
        this.descripcionRC = descripcionRC;
    }

    public InputText getComentariosRC() {
        return comentariosRC;
    }

    public void setComentariosRC(InputText comentariosRC) {
        this.comentariosRC = comentariosRC;
    }

    public List<RequisitoContenido> getListaRequisitoContenido() {
        listaRequisitoContenido =requisitoContenidoLogica.consultaRequisitoContenido();
        return listaRequisitoContenido;
    }

    public void setListaRequisitoContenido(List<RequisitoContenido> listaRequisitoContenido) {
        this.listaRequisitoContenido = listaRequisitoContenido;
    }
    
    public void seleccionarRequisitoContenido(SelectEvent e) {
        selectedRequisitoContenido = (RequisitoContenido) e.getObject();
        nombreProyectoRC.setValue(selectedRequisitoContenido.getNombreProyecto());
        numeroSolicitudRC.setValue(selectedRequisitoContenido.getNumeroSolicitud());
        tituloRC.setValue(selectedRequisitoContenido.getTitulo());
        //fechaRC.setDate(selectedRequisitoContenido.getFecha());
        solicitanteRC.setValue(selectedRequisitoContenido.getSolicitante());
        origenRC.setValue(selectedRequisitoContenido.getOrigen());
        estadoRC.setValue(selectedRequisitoContenido.getEstado());
        prioridadSolicitanteRC.setValue(selectedRequisitoContenido.getPrioridadSolicitante());
        prioridadRealizacionRC.setValue(selectedRequisitoContenido.getPrioridadRealizacion());
        verificadorRC.setValue(selectedRequisitoContenido.getVerificador());
        //fechaUltimaActualizacionRC.setValue(selectedRequisitoContenido.getFechaActualizacion());
        releaseRC.setValue(selectedRequisitoContenido.getRelease());
        esfuerzoRC.setValue(selectedRequisitoContenido.getEsfuerzo());
        descripcionRC.setValue(selectedRequisitoContenido.getDescripcion());
        comentariosRC.setValue(selectedRequisitoContenido.getComentarios());
    }

    public void registrarRequisitoContenido() {
        try {
            RequisitoContenido nuevoRequisitoContendio = new RequisitoContenido();
            nuevoRequisitoContendio.setNombreProyecto(nombreProyectoRC.getValue().toString());
            nuevoRequisitoContendio.setNumeroSolicitud(Integer.parseInt(numeroSolicitudRC.getValue().toString()));
            nuevoRequisitoContendio.setTitulo(tituloRC.getValue().toString());
            nuevoRequisitoContendio.setFecha(fechaRC);
            nuevoRequisitoContendio.setSolicitante(solicitanteRC.getValue().toString());
            nuevoRequisitoContendio.setOrigen(origenRC.getValue().toString());
            nuevoRequisitoContendio.setEstado(estadoRC.getValue().toString());
            nuevoRequisitoContendio.setPrioridadSolicitante(prioridadSolicitanteRC.getValue().toString());
            nuevoRequisitoContendio.setPrioridadRealizacion(prioridadRealizacionRC.getValue().toString());
            nuevoRequisitoContendio.setVerificador(verificadorRC.getValue().toString());
            nuevoRequisitoContendio.setFechaActualizacion(fechaUltimaActualizacionRC);
            nuevoRequisitoContendio.setRelease(releaseRC.getValue().toString());
            nuevoRequisitoContendio.setEsfuerzo(esfuerzoRC.getValue().toString());
            nuevoRequisitoContendio.setDescripcion(descripcionRC.getValue().toString());
            nuevoRequisitoContendio.setComentarios(comentariosRC.getValue().toString());
            requisitoContenidoLogica.registrarRequisitoContenido(nuevoRequisitoContendio);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El requisito no se registro correctamente!"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(requisitoContenidoVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
}
