package br.com.onsave.casamento.produces;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Flavio Andrade <onsave.com.br>
 */
@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceUnit
    private EntityManagerFactory factory;
    
    @Produces
    @RequestScoped
    public EntityManager getEntityManager() throws Exception {
        EntityManager em = factory.createEntityManager();
        return em;
    }
    
    public void close(@Disposes EntityManager em) {
        em.close();
    }
}