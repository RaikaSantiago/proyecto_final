/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Proyectos;
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
public class ProyectosFacade extends AbstractFacade<Proyectos> implements ProyectosFacadeLocal {

    @PersistenceContext(unitName = "proyecto_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectosFacade() {
        super(Proyectos.class);
    }

    @Override
    public Proyectos findID(Integer id) {
        String Consulta = "select p from Proyectos p where p.id = '"+id+"'";
         try {
            Query query = em.createQuery(Consulta);
            return (Proyectos) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
    
}
