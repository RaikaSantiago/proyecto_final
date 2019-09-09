/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.TipoDesarrollador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface TipoDesarrolladorFacadeLocal {

    void create(TipoDesarrollador tipoDesarrollador);

    void edit(TipoDesarrollador tipoDesarrollador);

    void remove(TipoDesarrollador tipoDesarrollador);

    TipoDesarrollador find(Object id);
    
    TipoDesarrollador findCargo(String cargo);

    List<TipoDesarrollador> findAll();

    List<TipoDesarrollador> findRange(int[] range);

    int count();
    
}
