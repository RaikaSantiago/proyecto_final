/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.TipoDesarrollador;
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
public class TipoDesarrolladorFacade extends AbstractFacade<TipoDesarrollador> implements TipoDesarrolladorFacadeLocal {

    @PersistenceContext(unitName = "proyecto_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDesarrolladorFacade() {
        super(TipoDesarrollador.class);
    }
    
    @Override
    public TipoDesarrollador findCargo(String cargo) {
         String Consulta = "select t from TipoDesarrollador t where t.cargo = '"+cargo+"'";
         try {
            Query query = em.createQuery(Consulta);
            return (TipoDesarrollador) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public TipoDesarrollador findID(Integer id) {
        String Consulta = "select t from TipoDesarrollador t where t.id = '"+id+"'";
         try {
            Query query = em.createQuery(Consulta);
            return (TipoDesarrollador) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
