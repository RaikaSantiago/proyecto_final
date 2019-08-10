/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.TipoDesarrollador;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author ALEJANDRA
 */
@Stateless
public class Tipo_DesarrolladorLogica implements Tipo_DesarrolladorLogicaLocal {

    @Override
    public void registrarTipoDesarrollador(TipoDesarrollador c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoDesarrollador consultarTipoDesarrollador(TipoDesarrollador c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDesarrollador> consultaTipoDesarrollador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarTipoDesarrollador(TipoDesarrollador c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
