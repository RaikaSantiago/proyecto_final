/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Empleados;
import Modelo.TipoDesarrollador;
import Persistencia.EmpleadosFacadeLocal;
import Persistencia.TipoDesarrolladorFacadeLocal;
import java.io.File;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import jxl.Sheet;
import jxl.Workbook;


@Stateless
public class EmpleadoLogica implements EmpleadoLogicaLocal {

    @EJB
    public EmpleadosFacadeLocal empleadoDAO;
    
    @EJB
    public TipoDesarrolladorFacadeLocal tipoDesarrolladorDAO;
    
    @Override
    public void registrarEmpleado(Empleados e) throws Exception {
        if (e == null) {
            throw new Exception("El empleado no tiene información");
        }
        
//        if (e.getId()== 0){
//             throw new Exception ("La ID es Obligatorio");  
//        }
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
        Empleados objEmpleado = empleadoDAO.findCedula(empleado.getCedula());
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
        if (e==null) {
            throw new Exception("El empleado no tiene información");
        }
        Empleados objBorrar = empleadoDAO.find(e);
        if(objBorrar == null){
            throw new Exception("El empleado no existe");
        }
        empleadoDAO.remove(objBorrar);
    }

    @Override
    public Empleados buscar(Integer id) {
        return empleadoDAO.findID(id);
    }

    @Override
    public String CargaDeDatosEmpleado(String archivo) throws Exception {
        Workbook archivoExcel = Workbook.getWorkbook(new File(archivo));
        Sheet hoja = archivoExcel.getSheet(0);
        int filas = hoja.getRows();
        for (int i = 1; i < filas; i++) {
            Empleados nuevoEmpleado = new Empleados();
            
            nuevoEmpleado.setNombre(hoja.getCell(0, i).getContents());
            nuevoEmpleado.setApellidos(hoja.getCell(1, i).getContents());
            nuevoEmpleado.setEmail(hoja.getCell(2, i).getContents());
            nuevoEmpleado.setCedula(hoja.getCell(3, i).getContents());
            nuevoEmpleado.setTelefonoFijo(hoja.getCell(4, i).getContents());
            nuevoEmpleado.setTelefonoMovil(hoja.getCell(5, i).getContents());
            nuevoEmpleado.setDireccion(hoja.getCell(6, i).getContents());
            nuevoEmpleado.setFechaNacimiento(null);
            nuevoEmpleado.setEdad(hoja.getCell(7, i).getContents());
            nuevoEmpleado.setSexo(hoja.getCell(8, i).getContents());
            nuevoEmpleado.setFechaIngreso(null);
            nuevoEmpleado.setAntiguedad(hoja.getCell(9, i).getContents());
            nuevoEmpleado.setClave(hoja.getCell(10, i).getContents());
            
            TipoDesarrollador newObjD = tipoDesarrolladorDAO.findID(Integer.parseInt(hoja.getCell(11, i).getContents()));
                        
            nuevoEmpleado.setTipoDesarrolladorId(newObjD);
            
            empleadoDAO.create(nuevoEmpleado);
            
        }
        return "Se registraron los datos de los empleados correctamente";
    }
    }

    
