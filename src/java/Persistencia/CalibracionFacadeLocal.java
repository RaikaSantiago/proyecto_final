/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Calibracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Desarrollo
 */
@Local
public interface CalibracionFacadeLocal {

    void create(Calibracion calibracion);

    void edit(Calibracion calibracion);

    void remove(Calibracion calibracion);

    Calibracion find(Object id);

    List<Calibracion> findAll();

    List<Calibracion> findRange(int[] range);

    int count();
    
}
