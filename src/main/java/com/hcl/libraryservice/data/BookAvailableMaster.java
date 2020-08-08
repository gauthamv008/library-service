/**
 * 
 */
package com.hcl.libraryservice.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author gowtham.v
 *
 * 08-Aug-2020 12:14:31 pm
 */
@Entity
@Table(name="book_available_details")
public class BookAvailableMaster {
	
	@Id
	@Column(name = "id")
	private String id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bookId")
	private BooksDetailsMaster booksDetailsMaster;
	
	@Column(name = "quantity")
	private int qty;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BooksDetailsMaster getBooksDetailsMaster() {
		return booksDetailsMaster;
	}

	public void setBooksDetailsMaster(BooksDetailsMaster booksDetailsMaster) {
		this.booksDetailsMaster = booksDetailsMaster;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
