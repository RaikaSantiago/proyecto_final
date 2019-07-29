/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.LenguajesProgramacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Desarrollo
 */
@Local
public interface LenguajesProgramacionFacadeLocal {

    void create(LenguajesProgramacion lenguajesProgramacion);

    void edit(LenguajesProgramacion lenguajesProgramacion);

    void remove(LenguajesProgramacion lenguajesProgramacion);

    LenguajesProgramacion find(Object id);

    List<LenguajesProgramacion> findAll();

    List<LenguajesProgramacion> findRange(int[] range);

    int count();
    
}
