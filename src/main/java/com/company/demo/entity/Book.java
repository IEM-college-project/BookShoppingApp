package com.company.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private Long bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "page_count")
	private Long pageCount;
	@Column(name = "price")
	private Double price;
	@Column(name = "stock")
	private Long stock;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "books_authors", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })

	private List<Author> authors;
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Long getPageCount() {
		return pageCount;
	}
	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Long bookId, String bookName, Long pageCount, Double price, Long stock, List<Author> authors) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.pageCount = pageCount;
		this.price = price;
		this.stock = stock;
		this.authors = authors;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", pageCount=" + pageCount + ", price=" + price
				+ ", stock=" + stock + ", authors=" + authors + "]";
	}
	
	
}
