/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Fases;
import java.util.List;
import javax.ejb.Local;


@Local
public interface FasesLogicaLocal {
    public void registrarFases(Fases f) throws Exception;
    public Fases consultarFases(Fases f) throws Exception;
    public List<Fases> consultaFases();
    public void modificarFases(Fases f) throws Exception;
}