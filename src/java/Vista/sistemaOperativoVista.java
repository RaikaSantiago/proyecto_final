/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Sistema_OperativoLogicaLocal;
import Modelo.SistemaOperativo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.component.inputtext.InputText;


@Named(value = "sistemaOperativoVista")
@RequestScoped
public class sistemaOperativoVista {
    
    @EJB
    Sistema_OperativoLogicaLocal sistemaOperativoLogica;

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
    
    public sistemaOperativoVista() {
    }
    
     public void registrarSistemaOperativo() {
      try {
        SistemaOperativo nuevoso = new SistemaOperativo();
        nuevoso.setNombre(txtNombre.getValue().toString());
        
        sistemaOperativoLogica.registrarSistemaOperativo(nuevoso);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "El Sistema Operativo  se ha Registrado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(sistemaOperativoVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
    
         public void modificarSistemaOperativo() {
      try {
        SistemaOperativo nuevoso = new SistemaOperativo();
        nuevoso.setNombre(txtNombre.getValue().toString());
        
         sistemaOperativoLogica.modificarSistemaOperativo(nuevoso);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "El Sistema Operativo  se ha Modificado Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Mensaje",
                 ex.getMessage()));
      Logger.getLogger(sistemaOperativoVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
}
