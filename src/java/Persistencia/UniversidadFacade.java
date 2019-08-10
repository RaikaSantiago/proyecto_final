/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Universidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class UniversidadFacade extends AbstractFacade<Universidad> implements UniversidadFacadeLocal {
    @PersistenceContext(unitName = "proyecto_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UniversidadFacade() {
        super(Universidad.class);
    }
    
}
