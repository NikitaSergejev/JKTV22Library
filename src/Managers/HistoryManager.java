/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;
import tools.KeyboardInput;

/**
 *
 * @author pupil
 */
public class HistoryManager {
    private Scanner scanner;
    private ReaderManager readerManager;
    private BookManager bookManager;
    
    
    public HistoryManager(Scanner scanner,BookManager bookManager, ReaderManager readerManager) {
        this.scanner = scanner;
        this.readerManager = readerManager;
        this.bookManager = bookManager;
        
    }
 
    public History giveOutBook(Book[] books, Reader[] readers){
        History history = new History();
        /**
         * Алгоритм выдачи книги читателю.
            1.вывести список читателей
            2. попросить пользователя выбрать номер читателей из списка
            3.добавить выбранного читателя из массива reader в history
            4. сделать 1-3 пункт для книги
            5.Создавать history, только если book.getCount() > 0, иначе возвращать null 
            5.добавить в history дату выдачи книги (текущую дату)
        */     
        
        readerManager.printListReaders(readers);        
        int selectedReaderNumber = KeyboardInput.inputNumber(1, 100);     
        history.setReader(readers[selectedReaderNumber-1]);
        bookManager.printListBooks(books);      
        int selectedBookNumber = KeyboardInput.inputNumber(1, 100);
        if(books[selectedBookNumber-1].getCount() > 0){
            history.setBook(books[selectedBookNumber-1]);
            books[selectedBookNumber-1].setCount(books[selectedBookNumber-1].getCount()-1);
            history.setDateOnHand(new GregorianCalendar().getTime());        
            return history;
        }else {
            System.out.println("All books all read");
            return null;
        }
    } 
    /**
     * Возврат книги
     * Выводим список читаемых книг
     * Выбираем возвращаемую книгу
     * Если метод (book.getCount() меньше getQuantity()) вернёт истину
     * выполняем увелечение count книги на 1 и возвращаем массив histories 
     * иначе возвращаем null  
     */
    public History[] returnBook(History[] histories) {
        bookManager.printListGiveOutBooks(histories);
        System.out.println("Select book for return: ");
        int historyNumber = (KeyboardInput.inputNumber(1, 100));
        if(histories[historyNumber-1].getBook().getCount()
                <histories[historyNumber-1].getBook().getQuantity()){
          histories[historyNumber-1].getBook().setCount(
                  histories[historyNumber-1].getBook().getCount()+1
          ); 
          histories[historyNumber-1].setDateBack(new GregorianCalendar().getTime());
        System.out.printf("Book \"%s\" returned %n",
                histories[historyNumber-1].getBook().getTitle()
            );
        return histories;
        }else{
            return null;
        }
        
    }
    
}
