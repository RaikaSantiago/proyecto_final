/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.BaseDatos;
import Persistencia.BaseDatosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class Base_DatosLogica implements Base_DatosLogicaLocal {

    @EJB
    BaseDatosFacadeLocal baseDatosDAO;
    
    @Override
    public void registrarBaseDatos(BaseDatos db) throws Exception {
        if (db.getNombre().equals("")){
             throw new Exception ("El nombre de la Base de Datos es Obligatorio");  
        }
        if (db.getTipo().equals("")){
             throw new Exception ("El Tipo de Base de Datos es Obligatorio");  
        }
        
        BaseDatos objDB = baseDatosDAO.findDB(db.getNombre());
        if (objDB != null){
          throw new Exception ("La Base de Datos ya existe!");
        }
        baseDatosDAO.create(db);
    }

    @Override
    public BaseDatos consultarBaseDatos(BaseDatos a) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BaseDatos> consultaBaseDatos() {
        return baseDatosDAO.findAll();
    }

    @Override
    public void modificarBaseDatos(BaseDatos db) throws Exception {
        if (db.getNombre().equals("")){
             throw new Exception ("El nombre de la Base de Datos es Obligatorio");  
        }
        if (db.getTipo().equals("")){
             throw new Exception ("El Tipo de Base de Datos es Obligatorio");  
        }
        
        BaseDatos objDB = baseDatosDAO.findDB(db.getNombre());
        if (objDB != null){
          throw new Exception ("La Base de Datos ya existe!");
        }
        baseDatosDAO.edit(db);
    }

    @Override
    public void eliminarBaseDatos(BaseDatos db) throws Exception {
        baseDatosDAO.remove(db);
    }

   

}
