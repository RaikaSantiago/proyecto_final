/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.RequisitoContenido;
import java.util.List;
import javax.ejb.Stateless;


@Stateless
public class Requisito_ContenidoLogica implements Requisito_ContenidoLogicaLocal {

    @Override
    public void registrarRequisitoContenido(RequisitoContenido c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RequisitoContenido consultarRequisitoContenido(RequisitoContenido c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RequisitoContenido> consultaRequisitoContenido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarRequisitoContenido(RequisitoContenido c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
