/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.BaseDatos;
import Modelo.Empleados;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class BaseDatosFacade extends AbstractFacade<BaseDatos> implements BaseDatosFacadeLocal {
    @PersistenceContext(unitName = "proyecto_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BaseDatosFacade() {
        super(BaseDatos.class);
    }

    @Override
    public BaseDatos findDB(String nombre) {
        String Consulta = "select db from BaseDatos db where db.nombre ="+nombre;
         try {
            Query query = em.createQuery(Consulta);
            return (BaseDatos) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
