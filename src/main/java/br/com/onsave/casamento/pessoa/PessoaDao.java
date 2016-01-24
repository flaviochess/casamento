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
    
    @Inject
    private Logger logger;
    
    public void save(Pessoa pessoa){
        dao.save(pessoa);
    }
    
}