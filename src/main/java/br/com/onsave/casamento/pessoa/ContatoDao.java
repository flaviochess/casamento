package br.com.onsave.casamento.pessoa;

import br.com.onsave.casamento.arquitetura.GenericDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Flavio Andrade <onsave.com.br>
 */
@Stateless
public class ContatoDao {

    @Inject
    private GenericDao dao;
    
    public void save(Contato contato){
        dao.save(contato);
    }
    
    public Contato update(Contato contato) {
        return (Contato) dao.update(contato);
    }

    public Contato load(Integer id){
        return (Contato) dao.load(id, Contato.class);
    }
    
    public Contato findById(Integer id) {
        return (Contato) dao.findById(id, Contato.class);
    }
    
    public List<Contato> findAll() {
        return (List<Contato>) dao.findAll(Contato.class);
    }
    
}
