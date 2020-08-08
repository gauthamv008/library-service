/**
 * 
 */
package com.hcl.libraryservice.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author gowtham.v
 *
 * 08-Aug-2020 11:56:00 am
 */
@Entity
@Table(name="book_details")
public class BooksDetailsMaster {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	
	@Column(name ="author")
	private String author;
	
	@Column(name ="title")
	private String title;
	
	@Column(name ="subject_category")
	private String subjectCategory;
	
	@Column(name ="rack_number")
	private String rackNumber;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "booksDetailsMaster", orphanRemoval = true)
	private BookAvailableMaster bookAvailableMaster;
	
	
	public BooksDetailsMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubjectCategory() {
		return subjectCategory;
	}

	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}

	public String getRackNumber() {
		return rackNumber;
	}

	public void setRackNumber(String rackNumber) {
		this.rackNumber = rackNumber;
	}

	public BookAvailableMaster getBookAvailableMaster() {
		return bookAvailableMaster;
	}

	public void setBookAvailableMaster(BookAvailableMaster bookAvailableMaster) {
		this.bookAvailableMaster = bookAvailableMaster;
	}
	
	}
