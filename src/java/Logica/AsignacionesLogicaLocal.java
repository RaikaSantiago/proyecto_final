/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Asignaciones;
import java.util.List;
import javax.ejb.Local;


@Local
public interface AsignacionesLogicaLocal {
    public void registrarAsignaciones(Asignaciones c) throws Exception;
    public Asignaciones consultarAsignaciones(Asignaciones a) throws Exception;
    public List<Asignaciones> consultaAsignaciones();
    public void modificarAsignaciones(Asignaciones c) throws Exception;
    public void eliminarAsignaciones(Asignaciones c) throws Exception;
}
