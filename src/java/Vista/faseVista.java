/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.FasesLogicaLocal;
import Modelo.Fases;
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
public class faseVista {

    @EJB
    FasesLogicaLocal faseLogica;

    private List<Fases> listaFases;
    private InputText txtId;
    private InputText txtNombre;
    private CommandButton Registrar;
    private CommandButton Modificar;
    private Fases selectedFase;

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

    public Fases getSelectedFase() {
        return selectedFase;
    }

    public void setSelectedFase(Fases selectedFase) {
        this.selectedFase = selectedFase;
    }

    public List<Fases> getListaFases() {
        listaFases = faseLogica.consultaFases();
        return listaFases;
    }

    public void setListaFases(List<Fases> listaFases) {
        this.listaFases = listaFases;
    }

    public faseVista() {

    }

    public void seleccionarFases(SelectEvent e) {
        selectedFase = (Fases) e.getObject();
        txtNombre.setValue(selectedFase.getNombre());
    }

    public void registrarFase() {
        try {
            Fases nuevaFase = new Fases();
            nuevaFase.setNombre(txtNombre.getValue().toString());
            faseLogica.registrarFases(nuevaFase);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Fase Registrada Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(faseVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarFase() {
        try {
            Fases nuevaFase = selectedFase;
            nuevaFase.setNombre(txtNombre.getValue().toString());
            faseLogica.modificarFases(nuevaFase);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Fase Modificada Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(faseVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
