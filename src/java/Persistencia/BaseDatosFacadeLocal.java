/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.BaseDatos;
import java.util.List;
import javax.ejb.Local;


@Local
public interface BaseDatosFacadeLocal {

    void create(BaseDatos baseDatos);

    void edit(BaseDatos baseDatos);

    void remove(BaseDatos baseDatos);

    BaseDatos find(Object id);
    
    BaseDatos findDB(String nombre);

    List<BaseDatos> findAll();

    List<BaseDatos> findRange(int[] range);

    int count();
    
}
