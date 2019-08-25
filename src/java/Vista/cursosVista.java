/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.CursosLogicaLocal;
import Modelo.Cursos;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

@ManagedBean
@RequestScoped
public class cursosVista {

    @EJB
    private CursosLogicaLocal cursosLogica;

    private List<Cursos> listaCursos;
    private InputText txtNombre;
    private InputText txtLugar;
    private Date txtFechaInicio;
    private Date txtFechaFin;
    private InputText txtId;
    private CommandButton Registrar;
    private CommandButton Modificar;
    private Cursos selectedCurso;

    public CursosLogicaLocal getCursosLogica() {
        return cursosLogica;
    }

    public void setCursosLogica(CursosLogicaLocal cursosLogica) {
        this.cursosLogica = cursosLogica;
    }

    public List<Cursos> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Cursos> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtLugar() {
        return txtLugar;
    }

    public void setTxtLugar(InputText txtLugar) {
        this.txtLugar = txtLugar;
    }

    public Date getTxtFechaInicio() {
        return txtFechaInicio;
    }

    public void setTxtFechaInicio(Date txtFechaInicio) {
        this.txtFechaInicio = txtFechaInicio;
    }

    public Date getTxtFechaFin() {
        return txtFechaFin;
    }

    public void setTxtFechaFin(Date txtFechaFin) {
        this.txtFechaFin = txtFechaFin;
    }

    public InputText getTxtId() {
        return txtId;
    }

    public void setTxtId(InputText txtId) {
        this.txtId = txtId;
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

    public Cursos getSelectedCurso() {
        return selectedCurso;
    }

    public void setSelectedCurso(Cursos selectedCurso) {
        this.selectedCurso = selectedCurso;
    }

    public cursosVista() {
    }

    public void seleccionarCursos (SelectEvent e){
        selectedCurso = (Cursos) e.getObject();
        txtId.setValue(selectedCurso.getId());
        txtNombre.setValue(selectedCurso.getNombre());
        txtLugar.setValue(selectedCurso.getLugar());
        //falta las fechas para poder seleccionar en las tablas.
    }
    
    public void registrarCurso() {
        try {
            Cursos nuevoCurso = new Cursos();
            nuevoCurso.setNombre(txtNombre.getValue().toString());
            nuevoCurso.setId(Integer.parseInt(txtId.getValue().toString()));
            nuevoCurso.setLugar(txtLugar.getValue().toString());
            nuevoCurso.setFechaInicio(txtFechaInicio);
            nuevoCurso.setFechaFin(txtFechaFin);

            cursosLogica.registrarCursos(nuevoCurso);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El Curso  se ha Registrado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(cursosVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarCurso() {
        try {
            Cursos nuevoCurso = new Cursos();
            nuevoCurso.setNombre(txtNombre.getValue().toString());
            nuevoCurso.setId(Integer.parseInt(txtId.getValue().toString()));
            nuevoCurso.setLugar(txtLugar.getValue().toString());
            nuevoCurso.setFechaInicio(txtFechaInicio);
            nuevoCurso.setFechaFin(txtFechaFin);

            cursosLogica.modificarCurso(nuevoCurso);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El Curso se ha Modificado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(cursosVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarCurso() {
        try {

            cursosLogica.eliminarCurso(selectedCurso);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El Curso se ha Eliminado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(cursosVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
