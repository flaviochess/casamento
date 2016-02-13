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
public class LogRecadoDao {

    @Inject
    private GenericDao dao;
    
    public void save(LogRecado logRecado){
        dao.save(logRecado);
    }
    
    public LogRecado update(LogRecado logRecado) {
        return (LogRecado) dao.update(logRecado);
    }

    public LogRecado load(Integer id){
        return (LogRecado) dao.load(id, LogRecado.class);
    }
    
    public LogRecado findById(Integer id) {
        return (LogRecado) dao.findById(id, LogRecado.class);
    }
    
    public List<LogRecado> findAll() {
        return (List<LogRecado>) dao.findAll(LogRecado.class);
    }
    
}