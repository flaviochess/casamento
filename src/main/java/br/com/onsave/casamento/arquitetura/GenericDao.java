package br.com.onsave.casamento.arquitetura;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import org.slf4j.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class GenericDao {

    @Inject
    private EntityManager em;
    
    @Inject
    private Logger logger;
    
    public void save(Modelable model){
        em.joinTransaction();
        em.persist(model);
    }
    
    public Modelable update(Modelable model){
        em.joinTransaction();
        return em.merge(model);
    }
    
    public Modelable findById(Serializable id, Class clazzType){
        try {
            return (Modelable) em.find(clazzType, id);
        } catch (NoResultException e) {
            return null;
        } catch (Exception ex){
            logger.error("Tecnicamente essa exceção nunca deveria ter sido lançada", ex);
            return null;
        }
    }
    
    public Modelable load(Serializable id, Class clazzType){
        try {
            return (Modelable) em.getReference(clazzType, id);
        } catch (NoResultException e) {
            return null;
        } catch (Exception ex){
            logger.error("Tecnicamente essa exceção nunca deveria ter sido lançada", ex);
            return null;
        }
    }
    
    public List<? extends Modelable> findAll(Class clazzType){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Modelable> criteria = builder.createQuery(clazzType);
        criteria.from(clazzType);
        return em.createQuery(criteria).getResultList();
    }
    
    public void remove(Modelable model){
        em.joinTransaction();
        em.remove(model);
    }
    
    public EntityManager getEntityManager(){
        return em;
    }
    
    public String getNewVoJpql(String alias, Class classVO){
        StringBuilder relationVoJpql = new StringBuilder();
        
        relationVoJpql.append("new ").append(classVO.getName()).append("(");
        for (Field field : classVO.getDeclaredFields()) {
            relationVoJpql.append(alias).append(".").append(field.getName()).append(",");
        }
        relationVoJpql.replace(relationVoJpql.length()-1, relationVoJpql.length(), ")");
        
        return relationVoJpql.toString();
    }
    
}