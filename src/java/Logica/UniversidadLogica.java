/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Universidad;
import Persistencia.UniversidadFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class UniversidadLogica implements UniversidadLogicaLocal {

    @EJB
    public UniversidadFacadeLocal universidadDAO;
    
    @Override
    public void registrarUniversidad(Universidad u) throws Exception {
        if (u == null) {
            throw new Exception("La universidad no tiene información");
        }
        if (u.getId() == 0) {
            throw new Exception("El ID de la universidad es obligatorio");
        }
        if (u.getNombre().equals("")) {
            throw new Exception("El nombre de la universidad es obligatorio");
        }
        if (u.getFechaGrado().equals("")) {
            throw new Exception("La fecha es obligatoria");
        }
        if (u.getTitulo().equals("")) {
            throw new Exception("El titulo de la universidad es obligatorio");
        }
        
        Universidad objUni = universidadDAO.findNombre(u.getNombre());
        if (objUni != null){
          throw new Exception ("La universidad ya existe!");
        }
        universidadDAO.create(u);
    }

    @Override
    public Universidad consultarUniversidad(Universidad c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Universidad> consultaUniversidad() {
        return universidadDAO.findAll();
    }

    @Override
    public void modificarUniversidad(Universidad u) throws Exception {
        if (u == null) {
            throw new Exception("La universidad no tiene información");
        }
        if (u.getId() == 0) {
            throw new Exception("El ID de la universidad es obligatorio");
        }
        if (u.getNombre().equals("")) {
            throw new Exception("El nombre de la universidad es obligatorio");
        }
        if (u.getFechaGrado().equals("")) {
            throw new Exception("La fecha es obligatoria");
        }
        if (u.getTitulo().equals("")) {
            throw new Exception("El titulo de la universidad es obligatorio");
        }
        
        Universidad objUni = universidadDAO.findNombre(u.getNombre());
        if (objUni != null){
          throw new Exception ("La universidad ya existe!");
        }
        universidadDAO.edit(u);
    }

   
}
