/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Empleados;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class EmpleadosFacade extends AbstractFacade<Empleados> implements EmpleadosFacadeLocal {
    @PersistenceContext(unitName = "proyecto_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadosFacade() {
        super(Empleados.class);
    }

    @Override
    public Empleados findCedula(String cedula) {
        String Consulta = "select e from Empleados e where e.cedula ="+cedula;
         try {
            Query query = em.createQuery(Consulta);
            return (Empleados) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
