/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.History;
import java.util.List;
import javax.persistence.EntityManager;
import tools.EntityManagerSingleton;

/**
 *
 * @author pupil
 */
public class HistoryFacade extends AbstractFacade<History>{  
    private EntityManager em;
    
   public HistoryFacade() {
        super(History.class);
        EntityManagerSingleton entityManagerSingleton = EntityManagerSingleton.getInstance();
        this.em=entityManagerSingleton.getEntityManager();
        
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<History> findAllReadingBooks() {
       // return em.createQuery("SELECT h FROM History h WHERE h.dateBack = null").getResultList();
       return null;
    }
}
