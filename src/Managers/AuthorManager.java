/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import entity.Author;
import facades.AuthorFacade;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class AuthorManager {
    private final Scanner scanner;
    private final AuthorFacade authorFacade;

    public AuthorManager(Scanner scanner) {
        this.scanner = scanner;
        this.authorFacade = new AuthorFacade();
        
    }
    public void printListAuthors() {
        System.out.println(" ---- Authors list -----");
        List<Author> authors = authorFacade.findAll();
        
    }
    

    public Author find(int id) {
        return authorFacade.find((long)id);
    }

    public void createAuthor() {
        Author author = new Author();
        System.out.println("--- Create author ----");
        System.out.println("Name:");
        author.setFirstname(scanner.nextLine());
        System.out.println("Surname:");
        author.setLastname(scanner.nextLine());
        authorFacade.create(author);
    }
    
}
