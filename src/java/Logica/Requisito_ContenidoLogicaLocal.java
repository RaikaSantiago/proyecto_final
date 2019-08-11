/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.RequisitoContenido;
import java.util.List;
import javax.ejb.Local;


@Local
public interface Requisito_ContenidoLogicaLocal {
    public void registrarRequisitoContenido(RequisitoContenido c) throws Exception;
    public RequisitoContenido consultarRequisitoContenido(RequisitoContenido c) throws Exception;
    public List<RequisitoContenido> consultaRequisitoContenido();
    public void modificarRequisitoContenido(RequisitoContenido c) throws Exception;
    public void eliminarRequisitoContenido(RequisitoContenido c) throws Exception;
}
