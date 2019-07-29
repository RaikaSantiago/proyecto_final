/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Nitrogeno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Desarrollo
 */
@Local
public interface NitrogenoFacadeLocal {

    void create(Nitrogeno nitrogeno);

    void edit(Nitrogeno nitrogeno);

    void remove(Nitrogeno nitrogeno);

    Nitrogeno find(Object id);

    List<Nitrogeno> findAll();

    List<Nitrogeno> findRange(int[] range);

    int count();
    
}
