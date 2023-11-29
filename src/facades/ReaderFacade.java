/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Reader;
import javax.persistence.EntityManager;
import tools.EntityManagerSingleton;

/**
 *
 * @author pupil
 */
public class ReaderFacade extends AbstractFacade<Reader> {
     private EntityManager em;
    
    public ReaderFacade() {
        super(Reader.class);
         EntityManagerSingleton entityManagerSingleton = EntityManagerSingleton.getInstance();
        this.em=entityManagerSingleton.getEntityManager();
        
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
