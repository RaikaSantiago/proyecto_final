/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Asignaciones;
import Persistencia.AsignacionesFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AsignacionesLogica implements AsignacionesLogicaLocal {
     @EJB
    public AsignacionesFacadeLocal asignacionesDAO;
    
    @Override
    public void registrarAsignaciones(Asignaciones c) throws Exception {
        if (c == null) {
            throw new Exception("La asignacion ha realizar no tiene información");
        }
        if (c.getHoras() == null){
          throw new Exception ("El campo horas no puede ir vacio");
        }
        if (c.getCantidadProyectos() == null){
          throw new Exception ("Agregue la cantidad de proyectos");
        }
        if (c.getPresupuestos() == null){
          throw new Exception ("El presupuesto debe estar digitado");
        }
        asignacionesDAO.create(c);
    }

    @Override
    public Asignaciones consultarAsignaciones(Asignaciones a) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Asignaciones> consultaAsignaciones() {
        return asignacionesDAO.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarAsignaciones(Asignaciones c) throws Exception {
        
        if(c==null){
            throw new Exception("El Nit hacido modificado");
        }
        if(c.getCantidadProyectos()==0){
            throw new Exception("La cantidad de proyectos  ha sido modificado");
        }
        if(c.getHoras() == null){
            throw new Exception("Las horas fueron modificadas");
        }
        Asignaciones objContratista = asignacionesDAO.find(c.getAsignacionesPK());
        if(objContratista == null){
            throw new Exception("La asignacion  ha sido Borrada");
        }
        asignacionesDAO.edit(c);
    }

    @Override
    public void eliminarAsignaciones(Asignaciones c) throws Exception {
   
       Asignaciones objBorrar = asignacionesDAO.find(c.getAsignacionesPK());
       if(objBorrar==null){
         throw new Exception("La asignacion no existe");  
       }
//       if(objBorrar.getEmpleadosList().size()>0 || objBorrar.getIngresoList().size()>0 ){
//         throw new Exception("El contratista tiene ingresos o contratos asociados");
//       }
       asignacionesDAO.remove(objBorrar);    
    }

  
}
