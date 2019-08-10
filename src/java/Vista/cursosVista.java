/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.CursosLogicaLocal;
import Modelo.Cursos;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;


@Named(value = "cursosVista")
@RequestScoped
public class cursosVista {
    
     @EJB
    private CursosLogicaLocal cursosLogica;
    
    private List<Cursos> listaCursos;
    private InputText txtNombre;
    private InputText txtLugar;
    private InputText txtFechaInicio;
    private InputText txtFechaFin;
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

    public InputText getTxtFechaInicio() {
        return txtFechaInicio;
    }

    public void setTxtFechaInicio(InputText txtFechaInicio) {
        this.txtFechaInicio = txtFechaInicio;
    }

    public InputText getTxtFechaFin() {
        return txtFechaFin;
    }

    public void setTxtFechaFin(InputText txtFechaFin) {
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
    
}
