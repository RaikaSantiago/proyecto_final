package Vista;

import Logica.Grado_AcademicoLogicaLocal;
import Logica.UniversidadLogicaLocal;
import Modelo.GradosAcademicos;
import Modelo.GradosAcademicosPK;
import Modelo.Universidad;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

@ManagedBean
@RequestScoped
public class gradosAcademicosVista {

    @EJB
    Grado_AcademicoLogicaLocal GradosAcademicosLogica;

    @EJB 
    UniversidadLogicaLocal universidadLogica;
    
    private List<GradosAcademicos> listaGradosA;
    private List<Universidad> listaUniversidad;
    private InputText txtTipo;
    private CommandButton Registrar;
    private CommandButton Modificar;
    private SelectOneMenu Universidad;
    private ArrayList<SelectItem> itemUniversidad;
    private Universidad selectedUniversidad;
    private GradosAcademicos selectedGradosA;

    public Grado_AcademicoLogicaLocal getFaseLogica() {
        return GradosAcademicosLogica;
    }

    public void setFaseLogica(Grado_AcademicoLogicaLocal GALogica) {
        this.GradosAcademicosLogica = GALogica;
    }

    public List<GradosAcademicos> getListaGradosA() {
        listaGradosA = GradosAcademicosLogica.consultaGradosAcademicos();
        return listaGradosA;
    }

    public void setListaGradosA(List<GradosAcademicos> listaGradosA) {
        this.listaGradosA = listaGradosA;
    }

    public InputText getTxtTipo() {
        return txtTipo;
    }

    public void setTxtTipo(InputText txtTipo) {
        this.txtTipo = txtTipo;
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

    public GradosAcademicos getSelectedGradosA() {
        return selectedGradosA;
    }

    public void setSelectedGradosA(GradosAcademicos selectedGradosA) {
        this.selectedGradosA = selectedGradosA;
    }

    public gradosAcademicosVista() {

    }

    public List<Universidad> getListaUniversidad() {
        listaUniversidad = universidadLogica.consultaUniversidad();
        return listaUniversidad;
    }

    public void setListaUniversidad(List<Universidad> listaUniversidad) {
        this.listaUniversidad = listaUniversidad;
    }

    public SelectOneMenu getUniversidad() {
        return Universidad;
    }

    public void setUniversidad(SelectOneMenu Universidad) {
        this.Universidad = Universidad;
    }

    public ArrayList<SelectItem> getItemUniversidad() {
        itemUniversidad = new ArrayList<>();
        for (int i = 0; i < getListaUniversidad().size(); i++) {
            itemUniversidad.add(new SelectItem(getListaUniversidad().get(i).getId().toString(),
                                               getListaUniversidad().get(i).getNombre()));
            
        }
        return itemUniversidad;
        
    }

    public void setItemUniversidad(ArrayList<SelectItem> itemUniversidad) {
        this.itemUniversidad = itemUniversidad;
    }

    public Universidad getSelectedUniversidad() {
        return selectedUniversidad;
    }

    public void setSelectedUniversidad(Universidad selectedUniversidad) {
        this.selectedUniversidad = selectedUniversidad;
    }

    
    
    public void seleccionarGradosAcademicos(SelectEvent e) {
        selectedGradosA = (GradosAcademicos) e.getObject();
        txtTipo.setValue(selectedGradosA.getTipo());
    }

    public void registrarGA() {
        try {
            GradosAcademicos nuevaGA = new GradosAcademicos();
            Universidad nuevaU = new Universidad();
            GradosAcademicosPK nuevaGAPK = new GradosAcademicosPK();
            
            
            nuevaU = universidadLogica.buscarU(Integer.parseInt(Universidad.getValue().toString()));
            nuevaGA.setTipo(txtTipo.getValue().toString());
            
            nuevaGAPK.setUniversidadId(nuevaU.getId());
            nuevaGA.setGradosAcademicosPK(nuevaGAPK); 
            GradosAcademicosLogica.registrarGradosAcademicos(nuevaGA);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El Grado Academico se ha  Registrado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(gradosAcademicosVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificarGA() {
        try {
            GradosAcademicos nuevaGA = selectedGradosA ;
            nuevaGA.setTipo(txtTipo.getValue().toString());

            GradosAcademicosLogica.modificarGradosAcademicos(nuevaGA);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "El Grado Academico se ha Modificado Satisfactoriamente"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(gradosAcademicosVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
