/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.RequisitoContenido;
import Persistencia.RequisitoContenidoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class Requisito_ContenidoLogica implements Requisito_ContenidoLogicaLocal {
    
    @EJB
    public RequisitoContenidoFacadeLocal RequisitoContenidoDAO;

    @Override
    public void registrarRequisitoContenido(RequisitoContenido c) throws Exception {
        if (c == null){
            throw new Exception("El registro del contenido no tiene información");
        }
        if (c.getNombreProyecto().equals("")){
            throw new Exception("El nombre del proyecto es obligatorio para el registro");
        }
        if (c.getNumeroSolicitud() == 0){
            throw new Exception("Se necesita un numero para la solicitud");
        }
        if (c.getTitulo().equals("")){
            throw new Exception("se requiere titulo de la solicitud");
        }
        if (c.getFecha() == null){
            throw new Exception("la fecha es necesaria para la solicitud");
        }
        if (c.getSolicitante() == null || c.getSolicitante().equals("")){
            throw new Exception("El nombre del solicitante es necesario para el registro");
        }
        if (c.getOrigen() == null || c.getOrigen().equals("")){
            throw new Exception("se necesita saber donde se relaizara el cambio del proyecto");
        }
        if (c.getEstado()== null || c.getEstado().equals("")){
            throw new Exception("asigne el estado actual de la solicitud");
        }
        if (c.getPrioridadSolicitante()== null || c.getPrioridadSolicitante().equals("")){
            throw new Exception("asigne para quien lo origina y solicita");
        }
        if (c.getPrioridadRealizacion()== null || c.getPrioridadRealizacion().equals("")){
            throw new Exception("asigne la prioridad que dio el comite de control de cambios");
        }
        if (c.getVerificador()== null || c.getVerificador().equals("")){
            throw new Exception("asigne la persona que se encargo de verificar los cambios");
        }
        if (c.getFechaActualizacion() == null){
            throw new Exception("Se necesita saber la fecha de la ultima actualización");
        }
        if (c.getRelease()== null || c.getRelease().equals("")){
            throw new Exception("En que parte del proyecto se relaiara el cambio");
        }
        if (c.getEsfuerzo()== null || c.getEsfuerzo().equals("")){
            throw new Exception("asigne el ezfuerzo necesario para poder realizar el cambio");
        }
        if (c.getDescripcion()== null || c.getDescripcion().equals("")){
            throw new Exception("registre descripcion del cambio a solicitar");
        }
        if (c.getComentarios()== null || c.getComentarios().equals("")){
            throw new Exception("Registre algun Comentario de los stakeholders o miembros del comité");
        }
        RequisitoContenidoDAO.create(c);
    }

    @Override
    public RequisitoContenido consultarRequisitoContenido(RequisitoContenido c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RequisitoContenido> consultaRequisitoContenido() {
        return RequisitoContenidoDAO.findAll();
    }

    @Override
    public void modificarRequisitoContenido(RequisitoContenido c) throws Exception {
        if (c == null){
            throw new Exception("El registro del contenido no tiene información");
        }
        if (c.getNombreProyecto().equals("")){
            throw new Exception("El nombre del proyecto es obligatorio para el registro");
        }
        if (c.getNumeroSolicitud() == 0){
            throw new Exception("Se necesita un numero para la solicitud");
        }
        if (c.getTitulo().equals("")){
            throw new Exception("se requiere titulo de la solicitud");
        }
        if (c.getFecha() == null){
            throw new Exception("la fecha es necesaria para la solicitud");
        }
        if (c.getSolicitante() == null || c.getSolicitante().equals("")){
            throw new Exception("El nombre del solicitante es necesario para el registro");
        }
        if (c.getOrigen() == null || c.getOrigen().equals("")){
            throw new Exception("se necesita saber donde se relaizara el cambio del proyecto");
        }
        if (c.getEstado()== null || c.getEstado().equals("")){
            throw new Exception("asigne el estado actual de la solicitud");
        }
        if (c.getPrioridadSolicitante()== null || c.getPrioridadSolicitante().equals("")){
            throw new Exception("asigne para quien lo origina y solicita");
        }
        if (c.getPrioridadRealizacion()== null || c.getPrioridadRealizacion().equals("")){
            throw new Exception("asigne la prioridad que dio el comite de control de cambios");
        }
        if (c.getVerificador()== null || c.getVerificador().equals("")){
            throw new Exception("asigne la persona que se encargo de verificar los cambios");
        }
        if (c.getFechaActualizacion() == null){
            throw new Exception("Se necesita saber la fecha de la ultima actualización");
        }
        if (c.getRelease()== null || c.getRelease().equals("")){
            throw new Exception("En que parte del proyecto se relaiara el cambio");
        }
        if (c.getEsfuerzo()== null || c.getEsfuerzo().equals("")){
            throw new Exception("asigne el ezfuerzo necesario para poder realizar el cambio");
        }
        if (c.getDescripcion()== null || c.getDescripcion().equals("")){
            throw new Exception("registre descripcion del cambio a solicitar");
        }
        RequisitoContenidoDAO.edit(c);
    }

    @Override
    public void eliminarRequisitoContenido(RequisitoContenido c) throws Exception {
        if (c == null){
            throw new Exception("El cambio de requisito no tiene información");
        }
        RequisitoContenido requisitoContenidoBorrar = RequisitoContenidoDAO.find(c.getRequisitoContenidoPK());
        if (requisitoContenidoBorrar == null){
            throw new Exception("El requisito no existe");
        }
        RequisitoContenidoDAO.remove(requisitoContenidoBorrar);
    }

    
}
