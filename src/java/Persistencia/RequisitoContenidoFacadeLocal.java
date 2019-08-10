/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.RequisitoContenido;
import java.util.List;
import javax.ejb.Local;


@Local
public interface RequisitoContenidoFacadeLocal {

    void create(RequisitoContenido requisitoContenido);

    void edit(RequisitoContenido requisitoContenido);

    void remove(RequisitoContenido requisitoContenido);

    RequisitoContenido find(Object id);

    List<RequisitoContenido> findAll();

    List<RequisitoContenido> findRange(int[] range);

    int count();
    
}
