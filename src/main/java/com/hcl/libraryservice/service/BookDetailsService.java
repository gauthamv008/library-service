/**
 * 
 */
package com.hcl.libraryservice.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hcl.libraryservice.data.BooksDetailsMaster;
import com.hcl.libraryservice.payload.BookDetails;
import com.hcl.libraryservice.payload.PagedResponse;

/**
 * @author gowtham.v
 *
 * 08-Aug-2020 2:42:39 pm
 */
public interface BookDetailsService {

	public PagedResponse<BookDetails> viewBookDetails(Specification<BooksDetailsMaster> spec, Pageable pageable);
	public BookDetails getBookIdDetails(Integer bookId);
	public List<BookDetails> getAuthorDetails(String author);
	public List<BookDetails> getSubjectCategoryDetails(String subjectCategory);
}
