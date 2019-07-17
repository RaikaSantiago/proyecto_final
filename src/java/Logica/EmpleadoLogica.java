/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Empleados;
import Persistencia.EmpleadosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author cristian
 */
@Stateless
public class EmpleadoLogica implements EmpleadoLogicaLocal {

    @EJB
    public EmpleadosFacadeLocal empleadoDAO;
    
    @Override
    public void registrarEmpleado(Empleados e) throws Exception {
        if (e == null) {
            throw new Exception("El empleado no tiene información");
        }
        if (e.getCedula().equals("")){
             throw new Exception ("La Cedula es Obligatorio");  
        }
        if (e.getNombre().equals("")){
          throw new Exception ("El nombre es obligatorio");
        }
        Empleados objEmpleado = empleadoDAO.findCedula(e.getCedula());
        if (objEmpleado != null){
          throw new Exception ("El empleado ya existe!");
        }
        empleadoDAO.create(e);
    }

    @Override
    public Empleados consultarEmpleado(Integer cedula) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleados> consultaEmpleados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarEmpleado(Empleados e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarEmpleado(Empleados e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
