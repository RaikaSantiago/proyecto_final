/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Universidad;
import java.util.List;
import javax.ejb.Local;


@Local
public interface UniversidadLogicaLocal {
   public void registrarUniversidad(Universidad c) throws Exception;
    public Universidad consultarUniversidad(Universidad c) throws Exception;
    public List<Universidad> consultaUniversidad();
    public void modificarUniversidad(Universidad c) throws Exception;
     public void eliminarUniversidad(Universidad u) throws Exception;
}
