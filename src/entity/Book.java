package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pupil
 */
@Entity
 public class Book implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic()
    private String title;
    private int publishedYear;
    @OneToMany
    private List<Author> authors = new ArrayList<>();
    private int quantity;//Количестово экземпляров в библиотеке
    private int count;//Количество экземпляров в наличии

    public Book() {
    }

    public Book(String title, int publishedYear, List<Author> authors, int quantity) {
        this.title = title;
        this.publishedYear = publishedYear;
        this.authors = authors;
        this.quantity = quantity;
        this.count = this.quantity;//книгу принесли и сразу записываем в quantity
    }

    public List<Author> getAuthors() {
        return authors;
    }   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.title);
        hash = 31 * hash + this.publishedYear;
        hash = 31 * hash + Objects.hashCode(this.authors);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.publishedYear != other.publishedYear) {
            return false;
        }
       
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.authors, other.authors)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book{");
        sb.append("title=").append(title);
        sb.append(", publishedYear=").append(publishedYear);
        sb.append(", authors=").append(Arrays.toString(authors.toArray()));
        sb.append(", count=").append(this.count);
        sb.append('}');
        return sb.toString();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private List<Author> ArrayList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
