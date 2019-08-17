/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Requisito;
import Persistencia.RequisitoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class RequisitoLogica implements RequisitoLogicaLocal {
    
    @EJB
    public RequisitoFacadeLocal requisitoDAO;

    @Override
    public void registrarRequisito(Requisito c) throws Exception {
        if (c == null){
            throw new Exception("El registro del requisito no tiene información");
        }
        if (c.getDescripcion().equals("")){
            throw new Exception("La descripcion del requisito es obligatorio para el registro");
        }
        if (c.getTipo().equals("")){
            throw new Exception("El tipo de requisito es obligatorio para hacer el registro");
        }
        if (c.getEstado().equals("")){
            throw new Exception("El estado del requisito es necesario para el registro");
        }
        
        requisitoDAO.create(c);
    }

    @Override
    public Requisito consultarRequisito(Requisito c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Requisito> consultaRequisito() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarRequisito(Requisito c) throws Exception {
        if (c == null){
            throw new Exception("El registro del requisito no tiene información");
        }
        if (c.getDescripcion().equals("")){
            throw new Exception("La descripcion del requisito es obligatorio para el registro");
        }
        if (c.getTipo().equals("")){
            throw new Exception("El tipo de requisito es obligatorio para hacer el registro");
        }
        if (c.getEstado().equals("")){
            throw new Exception("El estado del requisito es necesario para el registro");
        }
        
        requisitoDAO.edit(c);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void eliminarRequisito(Requisito c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
