/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class DatabaseManager {
    EntityManager em;

    public DatabaseManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JKTV22LibraryPU");
        em = emf.createEntityManager();
    }
    
    public void saveBook(Book book){
     /**
      *1. получаем список авторов из книги
      *2. если у автора поле ид = нулл, сохраняем 
      *3. инаяе делаем обновление
      *4. если ид книги = нулл, сохраняем книгу
      * 5. иначе делаем обновление
      */ 
     em.getTransaction().begin();
        for (int i = 0; i < book.getAuthors().size(); i++) {
            if(book.getAuthors().get(i).getId() === null){
                em.persist((book.getAuthors().get(i)));
            }else {
                em.merge(book.getAuthors().get(i));
            }
            if(book.getId()=== null){
                em.persist(book);
            }else{
                em.merge(book);
            }
            
        }
    }
}
