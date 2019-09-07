package Vista;

import Logica.Sistema_OperativoLogicaLocal;
import Modelo.SistemaOperativo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

@ManagedBean
@RequestScoped
public class sistemaOperativoVista {

    @EJB
    Sistema_OperativoLogicaLocal sistemaOperativoLogica;

    private List<SistemaOperativo> listaSO;

    public List<SistemaOperativo> getListaSO() {
        listaSO = sistemaOperativoLogica.consultaSistemaOperativo();
        return listaSO;
    }

    public void setListaSO(List<SistemaOperativo> listaSO) {
        this.listaSO = listaSO;
    }

    public Sistema_OperativoLogicaLocal getSistemaOperativoLogica() {
        return sistemaOperativoLogica;
    }

    public void setSistemaOperativoLogica(Sistema_OperativoLogicaLocal sistemaOperativoLogica) {
        this.sistemaOperativoLogica = sistemaOperativoLogica;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    private InputText txtNombre;
    private CommandButton Registrar;
    private CommandButton Modificar;
    private SistemaOperativo selectedSO;

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

    public SistemaOperativo getSelectedSO() {
        return selectedSO;
    }

    public void setSelectedSO(SistemaOperativo selectedSO) {
        this.selectedSO = selectedSO;
    }

    public sistemaOperativoVista() {

    }

    public void seleccionarSistemasOperativos(SelectEvent e) {
        selectedSO = (SistemaOperativo) e.getObject();
        txtNombre.setValue(selectedSO.getNombre());
    }

    public void registrarSistemaOperativo() {
        try {
            SistemaOperativo nuevoso = new SistemaOperativo();
            nuevoso.setNombre(txtNombre.getValue().toString());

            sistemaOperativoLogica.registrarSistemaOperativo(nuevoso);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El Sistema Operativo  se ha Registrado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(sistemaOperativoVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarSistemaOperativo() {
        try {
            SistemaOperativo nuevoso = new SistemaOperativo();
            nuevoso.setNombre(txtNombre.getValue().toString());

            sistemaOperativoLogica.modificarSistemaOperativo(nuevoso);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El Sistema Operativo  se ha Modificado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(sistemaOperativoVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
