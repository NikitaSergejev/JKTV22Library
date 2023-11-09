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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
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
 /**
         * Алгоритм выдачи книги читателю.
            1.вывести список читателей
            2. попросить пользователя выбрать номер читателей из списка
            3.добавить выбранного читателя из массива reader в history
            4. сделать 1-3 пункт для книги
            5.Создавать history, только если book.getCount() > 0, иначе возвращать null 
            5.добавить в history дату выдачи книги (текущую дату)
        */  
   
    public History giveOutBook(List<Book> books, List<Reader> readers){
        History history = new History();     
        readerManager.printListReaders(readers);        
        int selectedReaderNumber = KeyboardInput.inputNumber(1, 100);     
        history.setReader(readers.get(selectedReaderNumber-1));
        bookManager.printListBooks(books);      
        int selectedBookNumber = KeyboardInput.inputNumber(1, 100);
        if(books.get(selectedBookNumber-1).getCount() > 0){
            history.setBook(books.get(selectedBookNumber-1));
            books.get(selectedBookNumber-1).setCount(books.get(selectedBookNumber-1).getCount()-1);
            history.setDateOnHand(new GregorianCalendar().getTime());
            return history;
        }else{
            System.out.println("All books are read");
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
    public List<History> returnBook(List<History> histories) {
        bookManager.printListGiveOutBooks(histories);
        System.out.println("Select book for return: ");
        int historyNumber = (KeyboardInput.inputNumber(1, 100));
        
        if(histories.get(historyNumber).getBook().getCount()
                <histories.get(historyNumber).getBook().getQuantity()){
          histories.get(historyNumber).getBook().setCount(
                  histories.get(historyNumber).getBook().getCount()+1
          ); 
          histories.get(historyNumber-1).setDateBack(new GregorianCalendar().getTime());
        System.out.printf("Book \"%s\" returned %n",
                histories.get(historyNumber-1).getBook().getTitle()
            );
        return histories;
        }else{
            return null;
        }
        
    }
    /**
     * Алгоритм метода
     * 1.Создание MapBooks
     * 2.Проходим по всем книгам histories
     * и если в mapBooks нет ключа с книгой из истории
     *  добавляем ключ и устанавливаем значение 1
     * иначе
     * по ключу обновляем значение увеличивая его на 1
     * 3.Отсортировать mapBooks по значениям 
     * 4. Ввывести ключ и значение сортированного sortedMapBooks
     */
    public void RatingOfBooksByReadability(List<History> histories) {
        Map<Book,Integer> mapBooks = new HashMap<>();
        for(int i=0; i< histories.size(); i++) {
            if(!mapBooks.containsKey(histories.get(i).getBook())){
                mapBooks.put(histories.get(i).getBook(), 1);
            }else {
                mapBooks.put(histories.get(i).getBook(), mapBooks.get(histories.get(i).getBook())+1);
            }
        }
        //sort
        Map<Book, Integer> sortedMapBooks = mapBooks.entrySet()
                .stream()
                .sorted(Map.Entry.<Book, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry:: getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        int n = 1;
        for (Map.Entry<Book, Integer> entry : mapBooks.entrySet()) {
            System.out.printf("%d. %s: %d%n",
                  n,
                  entry.getKey().getTitle(),
                  entry.getValue()
            );
            n++;
            
        }
    }

    public void printMostReadingReader(List<History> histories) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
