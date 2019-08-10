/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.TipoDesarrollador;
import java.util.List;
import javax.ejb.Local;


@Local
public interface Tipo_DesarrolladorLogicaLocal {
    public void registrarTipoDesarrollador(TipoDesarrollador c) throws Exception;
    public TipoDesarrollador consultarTipoDesarrollador(TipoDesarrollador c) throws Exception;
    public List<TipoDesarrollador> consultaTipoDesarrollador();
    public void modificarTipoDesarrollador(TipoDesarrollador c) throws Exception; 
}
