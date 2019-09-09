/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Cursos;
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
public class CursosFacade extends AbstractFacade<Cursos> implements CursosFacadeLocal {

    @PersistenceContext(unitName = "proyecto_finalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursosFacade() {
        super(Cursos.class);
    }

    @Override
    public Cursos findNombre(String nombre) {
        String Consulta = "SELECT c FROM Cursos c WHERE c.nombre = '"+nombre+"'";
        try {
            Query query = em.createQuery(Consulta);
            return (Cursos) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
    
}
