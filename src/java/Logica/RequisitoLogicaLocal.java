/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Requisito;
import java.util.List;
import javax.ejb.Local;


@Local
public interface RequisitoLogicaLocal {
    public void registrarRequisito(Requisito c) throws Exception;
    public Requisito consultarRequisito(Requisito c) throws Exception;
    public List<Requisito> consultaRequisito();
    public void modificarRequisito(Requisito c) throws Exception; 
}
