/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.EmpleadoLogicaLocal;
import Modelo.Empleados;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Desarrollo
 */
@ManagedBean
@RequestScoped
public class vEmpleado {
    
    @EJB
    EmpleadoLogicaLocal empleadoLogica;
    
    List<Empleados> listaEmpleado;
    public vEmpleado() {
    }

    public List<Empleados> getListaEmpleado() {
        listaEmpleado = empleadoLogica.consultaEmpleados();
        return listaEmpleado;
    }

    public void setListaEmpleado(List<Empleados> listaEmpleado) {
        this.listaEmpleado = listaEmpleado;
    }
    
}
