/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Empleados;
import java.util.List;
import javax.ejb.Local;


@Local
public interface EmpleadosFacadeLocal {

    void create(Empleados empleados);

    void edit(Empleados empleados);

    void remove(Empleados empleados);

    Empleados find(Object id);
    
    Empleados findCedula(String cedula);

    List<Empleados> findAll();

    List<Empleados> findRange(int[] range);

    int count();
    
}
