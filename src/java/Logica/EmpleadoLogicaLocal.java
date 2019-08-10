/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Empleados;
import java.util.List;
import javax.ejb.Local;


@Local
public interface EmpleadoLogicaLocal {
    public Empleados ingresar(Empleados empleado)throws Exception;
    public void registrarEmpleado(Empleados e) throws Exception;
    public Empleados consultarEmpleado(String cedula) throws Exception;
    public List<Empleados> consultaEmpleados();
    public void modificarEmpleado(Empleados e) throws Exception;
    public void eliminarEmpleado(Empleados e) throws Exception;
}
