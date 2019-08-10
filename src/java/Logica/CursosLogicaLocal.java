/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Cursos;
import java.util.List;
import javax.ejb.Local;


@Local
public interface CursosLogicaLocal {
    public void registrarCursos(Cursos c) throws Exception;
    public Cursos consultarCurso(Cursos c) throws Exception;
    public List<Cursos> consultaCurso();
    public void modificarCurso(Cursos c) throws Exception;
    public void eliminarCurso(Cursos c) throws Exception;
}
