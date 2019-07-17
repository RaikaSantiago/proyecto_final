/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Asignaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface AsignacionesFacadeLocal {

    void create(Asignaciones asignaciones);

    void edit(Asignaciones asignaciones);

    void remove(Asignaciones asignaciones);

    Asignaciones find(Object id);

    List<Asignaciones> findAll();

    List<Asignaciones> findRange(int[] range);

    int count();
    
}
