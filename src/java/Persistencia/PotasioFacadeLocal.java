/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Potasio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Desarrollo
 */
@Local
public interface PotasioFacadeLocal {

    void create(Potasio potasio);

    void edit(Potasio potasio);

    void remove(Potasio potasio);

    Potasio find(Object id);

    List<Potasio> findAll();

    List<Potasio> findRange(int[] range);

    int count();
    
}
