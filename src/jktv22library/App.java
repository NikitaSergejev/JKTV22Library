/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jktv22library;

import entity.Author;
import entity.Book;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
class App {

    void run() {
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Select task: ");
            System.out.println("0. Exit");
            System.out.println("1.Add new book");
            System.out.print("Set task: ");
            int task = scanner.nextInt();scanner.nextLine();            
            switch (task) {
                case 0:
                    System.out.println("Good buy");
                    repeat = false;
                    break;
                case 1:
                    Book book = new Book();
                    System.out.print("Input title: ");
                    book.setTitle(scanner.nextLine());
                    System.out.println("Enter published year: ");
                    book.setPublishedYear(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("How many authors: ");
                    int countAuthors= scanner.nextInt(); scanner.nextLine();
                    for (int i = 0; i < countAuthors; i++) {
                        System.out.println(i+1+"author: ");
                         System.out.println("Author firstname: ");
                         String authorFirstname = scanner.nextLine();
                         System.out.println("Author lastname: ");
                         String authorLastname = scanner.nextLine();
                         book.addAuthor(new Author(authorFirstname,authorLastname));
                    }
                    System.out.println("Added book: ");
                    System.out.println(book.toString());
                    break;
                case 2:
                    
                    break;
                default:
                    System.out.println("Choice number from list !");;
            }
        } while (repeat);
    }
    
}
