/**
 * 
 */
package com.hcl.libraryservice.payload;

/**
 * @author gowtham.v
 *
 * 08-Aug-2020 11:59:28 am
 */
public class BookDetails {

	private int bookId;
	private String author;
	private String title;
	private String subjectCategory;
	private String rackNumber;
	private int availbleBooksInLibrary;
	
	public BookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
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
	public int getAvailbleBooksInLibrary() {
		return availbleBooksInLibrary;
	}
	public void setAvailbleBooksInLibrary(int availbleBooksInLibrary) {
		this.availbleBooksInLibrary = availbleBooksInLibrary;
	}
	public BookDetails(int bookId, String author, String title, String subjectCategory, String rackNumber,
			int availbleBooksInLibrary) {
		super();
		this.bookId = bookId;
		this.author = author;
		this.title = title;
		this.subjectCategory = subjectCategory;
		this.rackNumber = rackNumber;
		this.availbleBooksInLibrary = availbleBooksInLibrary;
	}
}
