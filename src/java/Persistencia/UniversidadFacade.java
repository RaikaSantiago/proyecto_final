/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Universidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cristian
 */
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

    @Override
    public Universidad findNombre(String nombre) {
        String Consulta = "select u from Universidad u where u.nombre = '"+nombre+"'";
         try {
            Query query = em.createQuery(Consulta);
            return (Universidad) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
