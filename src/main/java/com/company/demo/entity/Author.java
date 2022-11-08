package com.company.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "author_id")
	private Long authorId;
	@Column(name = "author_name")
	private String authorName;
	@Column(name = "author_email")
	private String authorEmail;
	@ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
	private List<Book> books;
	public Long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(Long authorId, String authorName, String authorEmail, List<Book> books) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorEmail = authorEmail;
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", authorEmail=" + authorEmail
				+ ", books=" + books + "]";
	}
    
	
	
}
