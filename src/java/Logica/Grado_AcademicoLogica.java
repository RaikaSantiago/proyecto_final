/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.GradosAcademicos;
import Persistencia.GradosAcademicosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class Grado_AcademicoLogica implements Grado_AcademicoLogicaLocal {
    
     @EJB
    public GradosAcademicosFacadeLocal gradosAcademicosDAO;
     
    @Override
    public void registrarGradosAcademicos(GradosAcademicos c) throws Exception {
        if (c == null) {
            throw new Exception("El grado Academico no tiene información");
        }
        if (c.getTipo().equals("")){
             throw new Exception ("El Tipo es Obligatorio");  
        }
        
        GradosAcademicos objGA = gradosAcademicosDAO.findTipo(c.getTipo());
        if (objGA != null){
          throw new Exception ("El Grado  Academico ya existe!");
        }
        gradosAcademicosDAO.create(c);
    }

    @Override
    public GradosAcademicos consultarGradosAcademicos(GradosAcademicos c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<GradosAcademicos> consultaGradosAcademicos() {
         return gradosAcademicosDAO.findAll();
    }

    @Override
    public void modificarGradosAcademicos(GradosAcademicos c) throws Exception {
          if (c == null) {
            throw new Exception("El grado Academico no tiene información");
        }
        if (c.getTipo().equals("")){
             throw new Exception ("El Tipo es Obligatorio");  
        }
        
        GradosAcademicos objGA = gradosAcademicosDAO.findTipo(c.getTipo());
        if (objGA != null){
          throw new Exception ("El Grado  Academico ya existe!");
        }
        gradosAcademicosDAO.edit(c);
    }

}
