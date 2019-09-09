/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Fases;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
@Stateless
public class FasesFacade extends AbstractFacade<Fases> implements FasesFacadeLocal {

    @PersistenceContext(unitName = "proyecto_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FasesFacade() {
        super(Fases.class);
    }

    @Override
    public Fases findNombre(String nombre) {
         String Consulta = "select f from Fases f where f.nombre = '"+nombre+"'";
         try {
            Query query = em.createQuery(Consulta);
            return (Fases) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
