/**
 * 
 */
package com.hcl.libraryservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hcl.libraryservice.data.BooksDetailsMaster;
import com.hcl.libraryservice.exception.ResourceNotFoundException;
import com.hcl.libraryservice.payload.BookDetails;
import com.hcl.libraryservice.payload.PagedResponse;
import com.hcl.libraryservice.repository.BookDetailsRepository;
import com.hcl.libraryservice.service.BookDetailsService;

/**
 * @author gowtham.v
 *
 * 08-Aug-2020 11:56:56 am
 */
@Service
public class BookDetailsServiceImpl implements BookDetailsService {
	
	@Autowired
	BookDetailsRepository bookDetailsRepo;
	
	public PagedResponse<BookDetails> viewBookDetails(Specification<BooksDetailsMaster> spec, Pageable pageable){
		
		Page<BooksDetailsMaster> booksMaster = bookDetailsRepo.findAll(spec,pageable);
		
		if(booksMaster.isEmpty() || booksMaster.getNumberOfElements() == 0)
			throw new ResourceNotFoundException("Resource Not found");
		
		List<BookDetails> list = booksMaster.stream().map(master -> {
			return new BookDetails(master.getBookId(), master.getAuthor(), master.getTitle(), master.getSubjectCategory(),
					master.getRackNumber(), master.getBookAvailableMaster().getQty());
		}).collect(Collectors.toList());
		
	    return new PagedResponse<>(list, booksMaster.getNumber(),
	    		booksMaster.getSize(),booksMaster.getTotalElements(),
	    		booksMaster.getTotalPages(),booksMaster.isLast());

	}
	
	public BookDetails getBookIdDetails(Integer bookId) {
		
		BooksDetailsMaster master = bookDetailsRepo.findById(bookId).orElseThrow(
				() -> new ResourceNotFoundException("Book Not found!!!"));
		
		return new BookDetails(master.getBookId(), master.getAuthor(), master.getTitle(), master.getSubjectCategory(),
				master.getRackNumber(), master.getBookAvailableMaster().getQty());
		
	}
	
	public List<BookDetails> getAuthorDetails(String author) {
		
		List<BooksDetailsMaster> list = bookDetailsRepo.findByAuthor(author);
		
		if(list.isEmpty() || list.size() == 0)
			throw new ResourceNotFoundException("Author not found in libaray");
		
		List<BookDetails> respone = list.stream().map(master -> {
			return new BookDetails(master.getBookId(), master.getAuthor(), master.getTitle(), master.getSubjectCategory(),
					master.getRackNumber(), master.getBookAvailableMaster().getQty());
		}).collect(Collectors.toList());
		
		
		 return respone;
		
	}
	
	public List<BookDetails> getSubjectCategoryDetails(String subjectCategory) {
		
		List<BooksDetailsMaster> list = bookDetailsRepo.findBySubjectCategory(subjectCategory);
		
		if(list.isEmpty() || list.size() == 0)
			throw new ResourceNotFoundException("Subject Category is not found in libaray");
		
		List<BookDetails> respone = list.stream().map(master -> {
			return new BookDetails(master.getBookId(), master.getAuthor(), master.getTitle(), master.getSubjectCategory(),
					master.getRackNumber(), master.getBookAvailableMaster().getQty());
		}).collect(Collectors.toList());
		
		
		 return respone;
		
	}

}
