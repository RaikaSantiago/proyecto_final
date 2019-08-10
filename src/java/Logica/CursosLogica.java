
package Logica;

import Modelo.Cursos;
import Persistencia.CursosFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class CursosLogica implements CursosLogicaLocal {
    @EJB
    CursosFacadeLocal cursosDAO;
    
    @Override
    public void registrarCursos(Cursos c) throws Exception {
       if (c.getId()== 0){
             throw new Exception ("El ID es Obligatorio");  
        }
        if (c.getNombre().equals("")){
             throw new Exception ("El nombre es Obligatorio");  
        }
        if (c.getLugar().equals("")){
             throw new Exception ("El lugar es Obligatorio");  
        }
        
        Cursos objCursos = cursosDAO.find(c.getNombre());
        if (objCursos != null){
          throw new Exception ("El curso ya existe!");
        }
        cursosDAO.create(c);
    }

    @Override
    public Cursos consultarCurso(Cursos c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cursos> consultaCurso() {
         return cursosDAO.findAll();
    }

    @Override
    public void modificarCurso(Cursos c) throws Exception {
        if (c.getId()== 0){
             throw new Exception ("El ID es Obligatorio");  
        }
        if (c.getNombre().equals("")){
             throw new Exception ("El nombre es Obligatorio");  
        }
        if (c.getLugar().equals("")){
             throw new Exception ("El lugar es Obligatorio");  
        }
        if (c.getFechaInicio().equals("")){
             throw new Exception ("La fecha del inicio del curso es Obligatorio");  
        }
        if (c.getFechaFin().equals("")){
             throw new Exception ("La fecha del  fin del curso es Obligatorio");  
        }
        
        Cursos objCursos = cursosDAO.find(c.getNombre());
        if (objCursos != null){
          throw new Exception ("El curso ya existe!");
        }
        cursosDAO.edit(c);
    }

    @Override
    public void eliminarCurso(Cursos c) throws Exception {
         Cursos objBorrar = cursosDAO.find(c.getId());
       if(objBorrar==null){
         throw new Exception("El curso no existe");  
       }
//       if(objBorrar.getEmpleadosList().size()>0 || objBorrar.getIngresoList().size()>0 ){
//         throw new Exception("El contratista tiene ingresos o contratos asociados");
//       }
       cursosDAO.remove(objBorrar);  
    }

   
}
