/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.SistemaOperativo;
import java.util.List;
import javax.ejb.Local;


@Local
public interface Sistema_OperativoLogicaLocal {
    public void registrarSistemaOperativo(SistemaOperativo c) throws Exception;
    public SistemaOperativo consultarSistemaOperativo(SistemaOperativo c) throws Exception;
    public List<SistemaOperativo> consultaSistemaOperativo();
    public void modificarSistemaOperativo(SistemaOperativo c) throws Exception; 
}
