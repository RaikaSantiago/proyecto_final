
package Logica;

import Modelo.SistemaOperativo;
import Persistencia.SistemaOperativoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class Sistema_OperativoLogica implements Sistema_OperativoLogicaLocal {
     
    @EJB
    public SistemaOperativoFacadeLocal sistemaOperativoDAO;
    
    @Override
    public void registrarSistemaOperativo(SistemaOperativo c) throws Exception {
      if (c == null) {
            throw new Exception("El sistema Operativo tiene información");
        }
        if (c.getNombre().equals("")){
          throw new Exception ("El nombre  no puede ir vacio");
        }
     
        sistemaOperativoDAO.create(c);
    }

    @Override
    public SistemaOperativo consultarSistemaOperativo(SistemaOperativo c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SistemaOperativo> consultaSistemaOperativo() {
        return sistemaOperativoDAO.findAll();
    }

    @Override
    public void modificarSistemaOperativo(SistemaOperativo c) throws Exception {
       if (c == null) {
            throw new Exception("El Sitema Operativo  no tiene información");
        }
        if (c.getNombre().equals("")){
          throw new Exception ("El nombre  no puede ir vacio");
        }
     
        sistemaOperativoDAO.edit(c);
    }

  
}
