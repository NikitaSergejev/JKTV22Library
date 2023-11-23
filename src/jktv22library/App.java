/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jktv22library;

import Managers.HistoryManager;
import Managers.ReaderManager;
import Managers.BookManager;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
class App {
    private Book[] books;
    private Reader[] readers;
    private History[] histories;
    private Scanner scanner;
    private ReaderManager readerManager;
    private BookManager bookManager;
    private HistoryManager historyManager;

    public App() {
        this.books = new Book[0];
        this.readers = new Reader[0];
        this.histories = new History[0];
        this.scanner = new Scanner(System.in);
        this.readerManager = new ReaderManager(scanner);
        this.bookManager = new BookManager(scanner);
        this.historyManager = new HistoryManager(scanner, bookManager, readerManager);      
    }

    void run() {
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Select task: ");
            System.out.println("0. Exit");
            System.out.println("1.Add new book");
            System.out.println("2.Add new reader");
            System.out.println("3.Give out a book to read");
            System.out.println("4.Print list readers");
            System.out.println("5.Print list books");
            System.out.println("6.Print list give out books");
            System.out.println("7.Return book");
            System.out.print("Set task: ");
            int task = scanner.nextInt();scanner.nextLine();            
            switch (task) {
                case 0:
                    System.out.println("Good buy");
                    repeat = false;
                    break;
                case 1:
                    bookManager.createBook();                   
                    break;
                case 2:                   
                    readerManager.createReader();
                    break;
                case 3:
                   addHistoryToArray(historyManager.giveOutBook(books, readers));
                    break;
                case 4:                 
                    readerManager.printListReaders(readers);
                    break;
                 case 5:
                    bookManager.printListBooks();
                    break;
                 case 6:
                    bookManager.printListGiveOutBooks(histories);
                    break;
                 case 7:                    
                    historyManager.returnBook(histories);
                    break;
                default:
                    System.out.println("Choice number from list !");;
            }
        } while (repeat);
    }

    private void addBookToArray(Book book) {
        this.books = Arrays.copyOf(books, books.length + 1);
        this.books[books.length -1 ] = book;
    }

    private void addReaderToArray(Reader reader) {
        this.readers = Arrays.copyOf(readers, readers.length + 1);
        this.readers[readers.length -1 ] = reader;
    }
    private void addHistoryToArray(History history) {
        this.histories = Arrays.copyOf(histories, histories.length + 1);
        this.histories[histories.length -1 ] = history;
    }
}
