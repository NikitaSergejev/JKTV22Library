/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class BookFacade extends AbstractFacade<Book> {
    
    private EntityManager em;
    
    public BookFacade() {
        super(Book.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTV22LibraryPU");
        this.em = emf.createEntityManager();
        
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
