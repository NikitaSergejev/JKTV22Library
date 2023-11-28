/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import entity.Author;
import entity.Book;
import entity.History;
import facades.AuthorFacade;
import facades.BookFacade;
import facades.HistoryFacade;
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
    private final HistoryFacade historyFacade;
    private final AuthorFacade authorFacade;
    public BookManager(Scanner scanner) {
        this.scanner = scanner;
        this.authorManager = new AuthorManager(scanner);
        this.bookFacade = new BookFacade();
        this.historyFacade = new HistoryFacade();
        this.authorFacade = new AuthorFacade();
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
            int idAuthor = InputFromKeyboard.inputNumberFromRange(1, 50);
            authorsBook.add(authorManager.find(idAuthor));        
        }
        book.setAuthors(authorsBook);      
        
        System.out.println("Added book: ");
        System.out.println(book.toString()); 
        bookFacade.create(book);
        }

    public void printListBooks() {
        List<Book> books = bookFacade.findAll();
        List<Author> authors = authorFacade.findAll();
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
            
            System.out.printf("%d. %s. %d. %s%n \n",
                    i+1,
                    books.get(i).getTitle(),
                    books.get(i).getPublishedYear(),
                    sbAuthorsBook.toString());                      
        }
    }

    public void printListGiveOutBooks() {
        List<History> histories = historyFacade.findAll();
         System.out.println("-----List books of hands ------");
         for (int i = 0; i < histories.size(); i++) {
            if(histories.get(i).getDateBack()== null);{
             System.out.printf("%d. \"%s\" to read %s %s. %s \n",
                     i+1,
                     histories.get(i).getBook().getTitle(),
                     histories.get(i).getReader().getFirstname(),
                     histories.get(i).getReader().getLastname(),
                     histories.get(i).getReader().getPhone()
                );
            }
        }
    }

    List<Book> books() {
        return bookFacade.findAll();
    }

    public Book findById(int id) {
        return bookFacade.find((long)id);
    }

    
}
