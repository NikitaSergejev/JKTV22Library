/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import entity.Author;
import entity.Book;
import entity.History;
import facades.BookFacade;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import tools.InputFromKeyboard;

/**
 *
 * @author pupil
 */
public class BookManager {
    private final Scanner scanner;
    private final AuthorManager authorManager;
    private final BookFacade bookFacade;
    public BookManager(Scanner scanner) {
        this.scanner = scanner;
        this.authorManager = new AuthorManager(scanner);
        this.bookFacade = new BookFacade();
    }
    public void createBook() {
        Book book = new Book();
        System.out.print("Input title: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Enter published year: ");
        book.setPublishedYear(scanner.nextInt());
        scanner.nextLine();
        //список авторов
        //если авторы есть, то вызвать, выбрать
        //иначе создать авторов
        authorManager.printListAuthors();
        System.out.println("Ели авторов в списке нет, нажми 0, если есть, нажми 1: ");
        int isAuthors = InputFromKeyboard.inputNumberFromRange(0, 1);
        if (isAuthors == 0) {
            authorManager.createAuthor();
        }
        
        System.out.print("How many authors: ");
        int countAuthors = InputFromKeyboard.inputNumberFromRange(1, 5);
        List<Author> authorsBook = new ArrayList<>();         
        for (int i = 0; i < countAuthors; i++) {
            System.out.printf("Выберите автора %d: ",i+1);
            int idAuthor = InputFromKeyboard.inputNumberFromRange(1, null);
            authorsBook.add(authorManager.find(idAuthor));
                
            
        }
        book.setAuthors(authorsBook);      
        
        System.out.println("Added book: ");
        System.out.println(book.toString()); 
        bookFacade.createBook(book);
        }

    public void printListBooks() {
        List<Book> books = bookFacade.findAll();
        System.out.println("-----List books ------");
        for (int i = 0; i < books.size(); i++) {
            StringBuilder sbAuthorsBook = new StringBuilder();
            for (int j = 0; j < books.get(i).getAuthors().size(); j++) {
                Author author = books.get(i).getAuthors().get(j);
                sbAuthorsBook.append(author.getFirstname());
                sbAuthorsBook.append(" ");
                sbAuthorsBook.append(author.getLastname());                                
                sbAuthorsBook.append(". ");
            }
            
            System.out.printf("%d. %s. %d. %s%n",
                    i+1,
                    books.get(i).getTitle(),
                    books.get(i).getPublishedYear(),
                    sbAuthorsBook.toString());                      
        }
    }

    public void printListGiveOutBooks(History[] histories) {
         System.out.println("-----List books of hands ------");
         for (int i = 0; i < histories.length; i++) {
            if(histories[i].getDateBack()== null);{
             System.out.printf("%d. \"%s\" to read %s %s. %s",
                     i+1,
                     histories[i].getBook().getTitle(),
                     histories[i].getReader().getFirstname(),
                     histories[i].getReader().getLastname(),
                     histories[i].getReader().getPhone()
                );
            }
        }
    }

    
}
