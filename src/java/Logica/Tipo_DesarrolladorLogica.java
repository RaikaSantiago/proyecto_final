
package Logica;

import Modelo.TipoDesarrollador;
import Persistencia.TipoDesarrolladorFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class Tipo_DesarrolladorLogica implements Tipo_DesarrolladorLogicaLocal {
    @EJB
    public TipoDesarrolladorFacadeLocal tipodesarrolladorDAO;
    
    @Override
    public void registrarTipoDesarrollador(TipoDesarrollador c) throws Exception {
       if (c == null) {
            throw new Exception("El tipo de desarrollador no  tiene información");
        }
        if (c.getNombreCargo().equals("")){
          throw new Exception ("El nombre del cargo  no puede ir vacio");
        }
     
        tipodesarrolladorDAO.create(c);
    }

    @Override
    public TipoDesarrollador consultarTipoDesarrollador(TipoDesarrollador c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDesarrollador> consultaTipoDesarrollador() {
       return tipodesarrolladorDAO.findAll(); 
    }

    @Override
    public void modificarTipoDesarrollador(TipoDesarrollador c) throws Exception {
        if (c == null) {
            throw new Exception("El tipo de desarrollador no  tiene información");
        }
        if (c.getNombreCargo().equals("")){
          throw new Exception ("El nombre del cargo  no puede ir vacio");
        }
     
        tipodesarrolladorDAO.edit(c); //To change body of generated methods, choose Tools | Templates.
    }

}
