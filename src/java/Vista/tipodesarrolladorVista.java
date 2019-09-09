package Vista;

import Logica.Tipo_DesarrolladorLogicaLocal;
import Modelo.TipoDesarrollador;
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
public class tipodesarrolladorVista {

    @EJB
    Tipo_DesarrolladorLogicaLocal tipodesarrolladorLogica;

    private List<TipoDesarrollador> listaTD;
    private InputText txtNombre_Cargo;
    private CommandButton Registrar;
    private CommandButton Modificar;
    private TipoDesarrollador selectedTD;

    public List<TipoDesarrollador> getListaTD() {
        listaTD = tipodesarrolladorLogica.consultaTipoDesarrollador();
        return listaTD;
    }

    public void setListaTD(List<TipoDesarrollador> listaTD) {
        this.listaTD = listaTD;
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

    public TipoDesarrollador getSelectedTD() {
        return selectedTD;
    }

    public void setSelectedTD(TipoDesarrollador selectedTD) {
        this.selectedTD = selectedTD;
    }

    public Tipo_DesarrolladorLogicaLocal getTipodesarrolladorLogica() {
        return tipodesarrolladorLogica;
    }

    public void setTipodesarrolladorLogica(Tipo_DesarrolladorLogicaLocal tipodesarrolladorLogica) {
        this.tipodesarrolladorLogica = tipodesarrolladorLogica;
    }

    public InputText getTxtNombre_Cargo() {
        return txtNombre_Cargo;
    }

    public void setTxtNombre_Cargo(InputText txtNombre_Cargo) {
        this.txtNombre_Cargo = txtNombre_Cargo;
    }

    public tipodesarrolladorVista() {
        
    }
    
    public void seleccionarTipoDesarrollador (SelectEvent e){
        selectedTD = (TipoDesarrollador) e.getObject();
        txtNombre_Cargo.setValue(selectedTD.getNombreCargo());
    }

    public void registrarTipoDesarrollador() {
        try {
            TipoDesarrollador nuevoTD = new TipoDesarrollador();
            nuevoTD.setNombreCargo(txtNombre_Cargo.getValue().toString());

            tipodesarrolladorLogica.registrarTipoDesarrollador(nuevoTD);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El Tipo de Desarrollador  se ha Registrado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al Registrar",
                            ex.getMessage()));
            Logger.getLogger(tipodesarrolladorVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarTipoDesarrllador() {
        try {
            TipoDesarrollador nuevoTD = selectedTD ;
            nuevoTD.setNombreCargo(txtNombre_Cargo.getValue().toString());

            tipodesarrolladorLogica.modificarTipoDesarrollador(nuevoTD);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El Tipo Desarrollador  se ha Modificado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(tipodesarrolladorVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
