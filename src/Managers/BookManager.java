/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import entity.Author;
import entity.Book;
import entity.History;
import java.util.Arrays;
import java.util.Scanner;
import tools.KeyboardInput;

/**
 *
 * @author pupil
 */
public class BookManager {
private Scanner scanner;

    public BookManager(Scanner scanner) {
        this.scanner = scanner;
    }
    public Book addBook() {
        Book book = new Book();
        System.out.print("Input title: ");
        book.setTitle(scanner.nextLine());
        System.out.print("Enter published year: ");
        book.setPublishedYear(scanner.nextInt());
        scanner.nextLine();
        System.out.print("How many authors: ");
        int countAuthors=(KeyboardInput.inputNumber(1, 10));
        for (int i = 0; i < countAuthors; i++) {
            System.out.println(i+1+"author: ");
            System.out.print("Author firstname: ");
            String authorFirstname = scanner.nextLine();
            System.out.print("Author lastname: ");
            String authorLastname = scanner.nextLine();
            book.addAuthor(new Author(authorFirstname,authorLastname));
        }
            System.out.print("Enter quantity copy: ");
            book.setQuantity(KeyboardInput.inputNumber(1, 10));
            book.setCount(book.getQuantity());
            System.out.println("Added book: ");
            System.out.println(book.toString());
            
            return book;
    }

    public void printListBooks(Book[] books) {
        System.out.println("-----List books --- ");                
        for (int i = 0; i < books.length; i++) {
            StringBuilder sbAuthorsBook = new StringBuilder();
            for (int j = 0; j < books[i].getAuthors().length; j++) {
                Author author = books[i].getAuthors()[j];
                sbAuthorsBook.append(author.getFirstname());
                sbAuthorsBook.append(" ");
                sbAuthorsBook.append(author.getLastname()+ ". ");                                
            }
            
            System.out.printf("%d. %s. %d. Authors: %s.  Count: %d%n",
                    i+1,
                    books[i].getTitle(),
                    books[i].getPublishedYear(),
                    sbAuthorsBook.toString(),                    
                    books[i].getCount()
            );
                    }
    }

    public void printListGiveOutBooks(History[] histories) {
         System.out.println("-----List books of hands ------");
         for (int i = 0; i < histories.length; i++) {
            if(histories[i].getDateBack()== null);{
             System.out.printf("%d. \"%s\" to read %s %s. %s%n",
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
