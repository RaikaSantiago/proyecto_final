/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Proyectos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALEJANDRA
 */
@Local
public interface ProyectoLogicaLocal {
    public void registrarProyectos(Proyectos c) throws Exception;
    public Proyectos consultarProyectos(Proyectos c) throws Exception;
    public List<Proyectos> consultaProyectos();
    public void modificarProyectos(Proyectos c) throws Exception; 
}
