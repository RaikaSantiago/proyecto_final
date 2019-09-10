/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Proyectos;
import Persistencia.ProyectosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class ProyectoLogica implements ProyectoLogicaLocal {
    
    @EJB
    public ProyectosFacadeLocal proyectoDAO;
    
    @Override
    public void registrarProyectos(Proyectos c) throws Exception {
        if (c == null) {
            throw new Exception("El proyecto no tiene información");
        }
        if (c.getCodigo().equals("")){
             throw new Exception ("El código es Obligatorio");  
        }
        if (c.getNombre().equals("")){
          throw new Exception ("El Nombre del proyecto es obligatorio");
        }
        if (c.getArea().equals("")){
             throw new Exception ("El Area del proyecto es Obligatorios");  
        }
        if (c.getFecha().equals("")){
            throw new Exception ("La fecha  es Obligatoria");
        }
        if (c.getFechaAsignacion().equals("")){
             throw new Exception ("La fecha Asignación es Obligatoria");  
        }
        if (c.getFechaFases().equals("")){
            throw new Exception ("La fecha de fases  es Obligatoria");
        }
        if (c.getFechaLiberacion().equals("")){
             throw new Exception ("La fecha de liberación  es Obligatoria");  
        }
        if (c.getCostoTotal()==0){
             throw new Exception ("El Costo total es Obligatorio");  
        }
        
        Proyectos objProyect = proyectoDAO.find(c.getCodigo());
        if (objProyect != null){
          throw new Exception ("El proyecto ya existe!");
        }
        proyectoDAO.create(c);
    }

    @Override
    public Proyectos consultarProyectos(Proyectos c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    @Override
    public void modificarProyectos(Proyectos c) throws Exception {
      if (c == null) {
            throw new Exception("El proyecto no tiene información");
        }
        if (c.getCodigo().equals("")){
             throw new Exception ("El código es Obligatorio");  
        }
        if (c.getNombre().equals("")){
          throw new Exception ("El Nombre del proyecto es obligatorio");
        }
        if (c.getArea().equals("")){
             throw new Exception ("El Area del proyecto es Obligatorios");  
        }
        if (c.getFecha().equals("")){
            throw new Exception ("La fecha  es Obligatoria");
        }
        if (c.getFechaAsignacion().equals("")){
             throw new Exception ("La fecha Asignación es Obligatoria");  
        }
        if (c.getFechaFases().equals("")){
            throw new Exception ("La fecha de fases  es Obligatoria");
        }
        if (c.getFechaLiberacion().equals("")){
             throw new Exception ("La fecha de liberación  es Obligatoria");  
        }
        if (c.getCostoTotal()==0){
             throw new Exception ("El Costo total es Obligatorio");  
        }
        
        Proyectos objProyect = proyectoDAO.find(c.getCodigo());
        if (objProyect != null){
          throw new Exception ("El proyecto ya existe!");
        }
        proyectoDAO.edit(c);
    }

    @Override
    public List<Proyectos> consultaProyectos() {
      return  proyectoDAO.findAll();
    }

    @Override
    public void eliminarProyectos(Proyectos c) throws Exception {
        Proyectos objBorrar = proyectoDAO.find(c.getCodigo());
       if(objBorrar==null){
         throw new Exception("El proyecto no existe");  
       }
//       if(objBorrar.getEmpleadosList().size()>0 || objBorrar.getIngresoList().size()>0 ){
//         throw new Exception("El contratista tiene ingresos o contratos asociados");
//       }
       proyectoDAO.remove(objBorrar);
    }

    @Override
    public Proyectos buscarP(Integer p) {
        return proyectoDAO.findID(p);
    }
}
