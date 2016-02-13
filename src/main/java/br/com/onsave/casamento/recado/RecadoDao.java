package br.com.onsave.casamento.recado;

import br.com.onsave.casamento.arquitetura.GenericDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Flavio Andrade <onsave.com.br>
 */
@Stateless
public class RecadoDao {

    @Inject
    private GenericDao dao;
    
    public void save(Recado recado){
        dao.save(recado);
    }
    
    public Recado update(Recado recado) {
        return (Recado) dao.update(recado);
    }

    public Recado load(Integer id){
        return (Recado) dao.load(id, Recado.class);
    }
    
    public Recado findById(Integer id) {
        return (Recado) dao.findById(id, Recado.class);
    }
    
    public List<Recado> findAll() {
        return (List<Recado>) dao.findAll(Recado.class);
    }
    
}
