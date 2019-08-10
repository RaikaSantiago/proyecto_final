/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.GradosAcademicos;
import java.util.List;
import javax.ejb.Local;


@Local
public interface Grado_AcademicoLogicaLocal {
    public void registrarGradosAcademicos(GradosAcademicos c) throws Exception;
    public GradosAcademicos consultarGradosAcademicos(GradosAcademicos c) throws Exception;
    public List<GradosAcademicos> consultaGradosAcademicos();
    public void modificarGradosAcademicos(GradosAcademicos c) throws Exception; 
}
