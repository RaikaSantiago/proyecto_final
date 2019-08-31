/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Fases;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface FasesFacadeLocal {

    void create(Fases fases);

    void edit(Fases fases);

    void remove(Fases fases);

    Fases find(Object id);
    
    Fases findNombre(String nombre);

    List<Fases> findAll();

    List<Fases> findRange(int[] range);

    int count();
    
}
