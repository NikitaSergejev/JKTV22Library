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
public class BookFacade {
    private EntityManager em;
    
    public BookFacade() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTV22LibraryPU");
        this.em = emf.createEntityManager();
    }
    public void create(Book book) {
        em.getTransaction().begin();
            em.persist(book);
        em.getTransaction().commit();
    }
    public Book find(Long id){
        return em.find(Book.class, id);
    }
    public List<Book> findAll(){ 
        
        return em.createQuery("SELECT book FROM Book book").getResultList();     
    }
    public void edit(Book book){
      em.getTransaction().begin();
            em.merge(book);
        em.getTransaction().commit();  
    }
}
