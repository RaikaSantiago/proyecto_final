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


@Stateless
public class EmpleadoLogica implements EmpleadoLogicaLocal {

    @EJB
    public EmpleadosFacadeLocal empleadoDAO;
    
    @Override
    public void registrarEmpleado(Empleados e) throws Exception {
        if (e == null) {
            throw new Exception("El empleado no tiene información");
        }
        if (e.getId()== 0){
             throw new Exception ("La ID es Obligatorio");  
        }
        if (e.getNombre().equals("")){
          throw new Exception ("El Nombre es obligatorio");
        }
        if (e.getApellidos().equals("")){
             throw new Exception ("Los Apellidos son Obligatorios");  
        }
        if (e.getEmail().equals("")){
            throw new Exception ("El Email es Obligatorio");
        }
        if (e.getCedula().equals("")){
             throw new Exception ("La Cedula es Obligatoria");  
        }
        if (e.getTelefonoFijo().equals("")){
            throw new Exception ("El Telefono Fijo es Obligatorio");
        }
        if (e.getTelefonoMovil().equals("")){
             throw new Exception ("El Telefono Movil es Obligatorio");  
        }
        if (e.getDireccion().equals("")){
             throw new Exception ("La Direccion es Obligatoria");  
        }
        if (e.getFechaNacimiento() == null){
             throw new Exception ("La Fecha de Nacimiento es Obligatoria");  
        }
        if (e.getEdad().equals("")){
             throw new Exception ("La Edad es Obligatoria");  
        }
        if (e.getSexo().equals("")){
             throw new Exception ("El Sexo es Obligatorio");  
        }
        if (e.getFechaIngreso()== null){
             throw new Exception ("La Fecha de Ingreso es Obligatoria");  
        }
        if (e.getAntiguedad().equals("")){
             throw new Exception ("La Antiguedad es Obligatoria");  
        }
        if (e.getClave().equals("")){
             throw new Exception ("La clave es obligatoria");  
        }
        
        Empleados objEmpleado = empleadoDAO.findCedula(e.getCedula());
        if (objEmpleado != null){
          throw new Exception ("El empleado ya existe!");
        }
        empleadoDAO.create(e);
    }

    

    @Override
    public List<Empleados> consultaEmpleados() {
      return  empleadoDAO.findAll();
    }

    @Override
    public void modificarEmpleado(Empleados e) throws Exception {
       if (e == null) {
            throw new Exception("El empleado no tiene información");
        }
        if (e.getId()== 0){
             throw new Exception ("La ID es Obligatorio");  
        }
        if (e.getNombre().equals("")){
          throw new Exception ("El Nombre es obligatorio");
        }
        if (e.getApellidos().equals("")){
             throw new Exception ("Los Apellidos son Obligatorios");  
        }
        if (e.getEmail().equals("")){
            throw new Exception ("El Email es Obligatorio");
        }
        if (e.getCedula().equals("")){
             throw new Exception ("La Cedula es Obligatoria");  
        }
        if (e.getTelefonoFijo().equals("")){
            throw new Exception ("El Telefono Fijo es Obligatorio");
        }
        if (e.getTelefonoMovil().equals("")){
             throw new Exception ("El Telefono Movil es Obligatorio");  
        }
        if (e.getDireccion().equals("")){
             throw new Exception ("La Direccion es Obligatoria");  
        }
        if (e.getFechaNacimiento() == null){
             throw new Exception ("La Fecha de Nacimiento es Obligatoria");  
        }
        if (e.getEdad().equals("")){
             throw new Exception ("La Edad es Obligatoria");  
        }
        if (e.getSexo().equals("")){
             throw new Exception ("El Sexo es Obligatorio");  
        }
        if (e.getFechaIngreso()== null){
             throw new Exception ("La Fecha de Ingreso es Obligatoria");  
        }
        if (e.getAntiguedad().equals("")){
             throw new Exception ("La Antiguedad es Obligatoria");  
        }
        if (e.getClave().equals("")){
             throw new Exception ("La Antiguedad es Obligatoria");  
        }
        
        Empleados objEmpleado = empleadoDAO.findCedula(e.getCedula());
        if (objEmpleado != null){
          throw new Exception ("El empleado ya existe!");
        }
        empleadoDAO.edit(e);
    }

    @Override
    public Empleados Ingresar(Empleados empleado) throws Exception {
         if (empleado == null){
            throw new Exception("Usuario vacio");
        }
        if (empleado.getCedula() == null){
            throw new Exception("La Cedula es obligatoria");
        }
        if (empleado.getClave().equals("")){
            throw new Exception("Clave es obligatorio");
        }
        Empleados objEmpleado = empleadoDAO.find(empleado.getCedula());
        if (objEmpleado == null){
            throw new Exception("Usuario no registrado!");
        }
        if (!empleado.getClave().equals(objEmpleado.getClave())){
            throw new Exception("La clave no es valida!");
        }
        return objEmpleado;
    }

    @Override
    public Empleados consultarEmpleado(String cedula) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarEmpleado(Empleados e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

    