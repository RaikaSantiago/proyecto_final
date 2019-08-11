
package Vista;

import Logica.Grado_AcademicoLogicaLocal;
import Modelo.GradosAcademicos;
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



@ManagedBean
@RequestScoped
public class gradosAcademicosVista {

    @EJB
    Grado_AcademicoLogicaLocal GradosAcademicosLogica;
    
    private List<GradosAcademicos> listaGradosA;
    private InputText txtTipo;
    private CommandButton Registrar;
    private CommandButton Modificar;
    private GradosAcademicos selectedGradosA;
    
    public Grado_AcademicoLogicaLocal getFaseLogica() {
        return GradosAcademicosLogica;
    }

    public void setFaseLogica(Grado_AcademicoLogicaLocal GALogica) {
        this.GradosAcademicosLogica = GALogica;
    }

    public List<GradosAcademicos> getListaGradosA() {
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
    
     public void registrarGA() {
      try {
        GradosAcademicos nuevaGA = new GradosAcademicos();
        nuevaGA.setTipo(txtTipo.getValue().toString());
        GradosAcademicosLogica.registrarGradosAcademicos(nuevaGA);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "Fase Registrada Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(gradosAcademicosVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
     
    public void modificarFase() {
      try {
       GradosAcademicos nuevaGA = new GradosAcademicos();
        nuevaGA.setTipo(txtTipo.getValue().toString());
      
        GradosAcademicosLogica.modificarGradosAcademicos(nuevaGA);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "Fase Modificada Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(gradosAcademicosVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    } 
}
