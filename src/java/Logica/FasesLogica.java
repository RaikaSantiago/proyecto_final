/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Fases;
import Persistencia.FasesFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class FasesLogica implements FasesLogicaLocal {

    @EJB
    public FasesFacadeLocal fasesDAO;
    
    @Override
    public void registrarFases(Fases f) throws Exception {
        if (f == null) {
            throw new Exception("La Fase no tiene información");
        }
        if (f.getId()== 0){
             throw new Exception ("El ID de la Fase es Obligatorio");  
        }
        if (f.getNombre().equals("")){
          throw new Exception ("El Nombre de la Fase es obligatorio");
        }
        
        Fases objFase = fasesDAO.findNombre(f.getNombre());
        if (objFase != null){
          throw new Exception ("La Fase ya existe!");
        }
        fasesDAO.create(f);
    }

    @Override
    public Fases consultarFases(Fases c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Fases> consultaFases() {
        return fasesDAO.findAll();
    }

    @Override
    public void modificarFases(Fases f) throws Exception {
        if (f == null) {
            throw new Exception("La Fase no tiene información");
        }
        if (f.getId()== 0){
             throw new Exception ("El ID de la Fase es Obligatorio");  
        }
        if (f.getNombre().equals("")){
          throw new Exception ("El Nombre de la Fase es obligatorio");
        }
        
        Fases objFase = fasesDAO.findNombre(f.getNombre());
        if (objFase != null){
          throw new Exception ("La Fase ya existe!");
        }
        fasesDAO.create(f);
    }
}
