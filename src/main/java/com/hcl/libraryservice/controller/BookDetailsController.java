/**
 * 
 */
package com.hcl.libraryservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.libraryservice.data.BooksDetailsMaster;
import com.hcl.libraryservice.payload.BookDetails;
import com.hcl.libraryservice.payload.PagedResponse;
import com.hcl.libraryservice.service.BookDetailsService;
import com.hcl.libraryservice.service.UserDetailsService;
import com.hcl.libraryservice.utils.Constants;
/**
 * @author gowtham.v
 *
 * 08-Aug-2020 1:29:07 pm
 */
@RestController
@RequestMapping("/bookMgnt")
public class BookDetailsController {

private static final Logger log = LoggerFactory.getLogger(BookDetailsController.class);
	
	@Autowired
	BookDetailsService bookDetailsService;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping("/v1/{userId}/getBooks/{bookId}")
	public BookDetails getBookDetails(
			@PathVariable(required = true) Integer userId,
			@PathVariable(required = true) Integer bookId) {
		log.info("UserId :: "+ userId +", book id ::"+ bookId);
		
		userDetailsService.getUserDetails(userId, "");
		
		return bookDetailsService.getBookIdDetails(bookId);
	}
	
	@GetMapping("/v1/{userId}/getBooksByAuthor/{author}")
	public List<BookDetails> getBookByAuthorDetails(
			@PathVariable(required = true) Integer userId,
			@PathVariable(required = true) String author) {
		log.info("UserId :: "+ userId +", Author ::"+ author);
		
		userDetailsService.getUserDetails(userId, "");
		
		return bookDetailsService.getAuthorDetails(author);
	}
	
	@GetMapping("/v1/{userId}/getBooksBySubjectCategory/{subjectCategory}")
	public List<BookDetails> getBookByBySubjectCategory(
			@PathVariable(required = true) Integer userId,
			@PathVariable(required = true) String subjectCategory) {
		log.info("UserId :: "+ userId +", SubjectCategory ::"+ subjectCategory);
		
		userDetailsService.getUserDetails(userId, "");
		
		return bookDetailsService.getSubjectCategoryDetails(subjectCategory);
	}

	@GetMapping("/v1/getBooks")
	public PagedResponse<BookDetails> viewBooksDetails(
			//@PathVariable Integer userId,
			@RequestParam(value = "page", defaultValue = Constants.PAGE_DEFAULT_NUMBER,required = false) int page, 
			@RequestParam(value ="size", defaultValue =Constants.PAGE_DEFAULT_SIZE,required = false) int size,
			@RequestParam(value ="sort",defaultValue = "registeredDate",required = false) String sort,
			@RequestParam(value ="order", defaultValue =Constants.SORT_DIR,required = false) String order,
			Specification<BooksDetailsMaster> spec){
		
		Pageable pageable =  (size != 0 ?PageRequest.of(page-1, size, order.trim()
				.equals(Constants.SORT_DIR)?Sort.Direction.DESC:Sort.Direction.ASC , sort): Pageable.unpaged());

		//log.info("user Id :: "+ userId);
		
		return bookDetailsService.viewBookDetails(spec, pageable);
		
	}
	
	
	
	
}
