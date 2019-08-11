
package Vista;

import Logica.Tipo_DesarrolladorLogicaLocal;
import Modelo.TipoDesarrollador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.component.inputtext.InputText;


@Named(value = "tipodesarrolladorVista")
@RequestScoped
public class tipodesarrolladorVista {

    @EJB
    Tipo_DesarrolladorLogicaLocal tipodesarrolladorLogica;
    
    private InputText txtNombre_Cargo;

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
     public void registrarTipoDesarrollador() {
      try {
        TipoDesarrollador nuevoTD = new TipoDesarrollador();
        nuevoTD.setNombreCargo(txtNombre_Cargo.getValue().toString());
        
        tipodesarrolladorLogica.registrarTipoDesarrollador(nuevoTD);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "El Tipo de Desarrollador  se ha Registrado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(tipodesarrolladorVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
    
         public void modificarTipoDesarrllador() {
      try {
        TipoDesarrollador nuevoTD = new TipoDesarrollador();
        nuevoTD.setNombreCargo(txtNombre_Cargo.getValue().toString());
        
         tipodesarrolladorLogica.modificarTipoDesarrollador(nuevoTD);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "El Tipo Desarrollador  se ha Modificado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(tipodesarrolladorVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
}
