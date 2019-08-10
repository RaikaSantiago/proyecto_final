/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.SistemaOperativo;
import java.util.List;
import javax.ejb.Stateless;


@Stateless
public class Sistema_OperativoLogica implements Sistema_OperativoLogicaLocal {

    @Override
    public void registrarSistemaOperativo(SistemaOperativo c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SistemaOperativo consultarSistemaOperativo(SistemaOperativo c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SistemaOperativo> consultaSistemaOperativo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarSistemaOperativo(SistemaOperativo c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
