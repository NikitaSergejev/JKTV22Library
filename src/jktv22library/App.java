/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jktv22library;

import Managers.HistoryManager;
import Managers.ReaderManager;
import Managers.BookManager;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
class App {
    private final Scanner scanner;
    private final ReaderManager readerManager;
    private final BookManager bookManager;
    private final HistoryManager historyManager;

    public App() {
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
                   historyManager.giveOutBook();
                    break;
                case 4:                 
                    readerManager.printListReaders();
                    break;
                 case 5:
                    bookManager.printListBooks();
                    break;
                 case 6:
                    bookManager.printListGiveOutBooks();
                    break;
                 case 7:                    
                    historyManager.returnBook();
                    break;
                default:
                    System.out.println("Choice number from list !");;
            }
        } while (repeat);
    }    
}
