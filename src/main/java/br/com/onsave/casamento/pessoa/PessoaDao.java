package br.com.onsave.casamento.pessoa;

import br.com.onsave.casamento.arquitetura.GenericDao;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;

/**
 *
 * @author Flavio Andrade <onsave.com.br>
 */
@Stateless
public class PessoaDao {

    @Inject
    private GenericDao dao;
    
    public void save(Pessoa pessoa){
        dao.save(pessoa);
    }
    
    public Pessoa update(Pessoa pessoa) {
        return (Pessoa) dao.update(pessoa);
    }

    public Pessoa load(String id){
        return (Pessoa) dao.load(id, Pessoa.class);
    }
    
    public Pessoa findById(String id) {
        return (Pessoa) dao.findById(id, Pessoa.class);
    }
    
}