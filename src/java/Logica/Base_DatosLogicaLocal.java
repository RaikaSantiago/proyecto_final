/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.BaseDatos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALEJANDRA
 */
@Local
public interface Base_DatosLogicaLocal {
   public void registrarBaseDatos(BaseDatos c) throws Exception;
    public BaseDatos consultarBaseDatos(BaseDatos a) throws Exception;
    public List<BaseDatos> consultaBaseDatos();
    public void modificarBaseDatos(BaseDatos c) throws Exception;
    public void eliminarBaseDatos(BaseDatos c) throws Exception;
}
