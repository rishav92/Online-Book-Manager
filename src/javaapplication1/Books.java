/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author GaVisic
 */
@Entity
@Table(name = "BOOKS", catalog = "", schema = "DBMS")
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b")
    , @NamedQuery(name = "Books.findByIsbnNumber", query = "SELECT b FROM Books b WHERE b.isbnNumber = :isbnNumber")
    , @NamedQuery(name = "Books.findByBookName", query = "SELECT b FROM Books b WHERE b.bookName = :bookName")
    , @NamedQuery(name = "Books.findByAuthor", query = "SELECT b FROM Books b WHERE b.author = :author")
    , @NamedQuery(name = "Books.findByPublisher", query = "SELECT b FROM Books b WHERE b.publisher = :publisher")
    , @NamedQuery(name = "Books.findByCateory", query = "SELECT b FROM Books b WHERE b.cateory = :cateory")
    , @NamedQuery(name = "Books.findByPrice", query = "SELECT b FROM Books b WHERE b.price = :price")})
public class Books implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ISBN_NUMBER")
    private String isbnNumber;
    @Basic(optional = false)
    @Column(name = "BOOK_NAME")
    private String bookName;
    @Basic(optional = false)
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "PUBLISHER")
    private String publisher;
    @Basic(optional = false)
    @Column(name = "CATEORY")
    private String cateory;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private BigInteger price;

    public Books() {
    }

    public Books(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public Books(String isbnNumber, String bookName, String author, String cateory, BigInteger price) {
        this.isbnNumber = isbnNumber;
        this.bookName = bookName;
        this.author = author;
        this.cateory = cateory;
        this.price = price;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        String oldIsbnNumber = this.isbnNumber;
        this.isbnNumber = isbnNumber;
        changeSupport.firePropertyChange("isbnNumber", oldIsbnNumber, isbnNumber);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        String oldBookName = this.bookName;
        this.bookName = bookName;
        changeSupport.firePropertyChange("bookName", oldBookName, bookName);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        String oldAuthor = this.author;
        this.author = author;
        changeSupport.firePropertyChange("author", oldAuthor, author);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        String oldPublisher = this.publisher;
        this.publisher = publisher;
        changeSupport.firePropertyChange("publisher", oldPublisher, publisher);
    }

    public String getCateory() {
        return cateory;
    }

    public void setCateory(String cateory) {
        String oldCateory = this.cateory;
        this.cateory = cateory;
        changeSupport.firePropertyChange("cateory", oldCateory, cateory);
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        BigInteger oldPrice = this.price;
        this.price = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbnNumber != null ? isbnNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.isbnNumber == null && other.isbnNumber != null) || (this.isbnNumber != null && !this.isbnNumber.equals(other.isbnNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Books[ isbnNumber=" + isbnNumber + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
