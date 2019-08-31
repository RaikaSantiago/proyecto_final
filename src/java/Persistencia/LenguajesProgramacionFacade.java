/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.LenguajesProgramacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author usuario
 */
@Stateless
public class LenguajesProgramacionFacade extends AbstractFacade<LenguajesProgramacion> implements LenguajesProgramacionFacadeLocal {

    @PersistenceContext(unitName = "proyecto_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LenguajesProgramacionFacade() {
        super(LenguajesProgramacion.class);
    }
    
}
