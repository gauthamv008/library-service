/**
 * 
 */
package com.hcl.libraryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hcl.libraryservice.data.BooksDetailsMaster;

/**
 * @author gowtham.v
 *
 * 08-Aug-2020 11:56:35 am
 */
@Repository
public interface BookDetailsRepository 
	extends PagingAndSortingRepository<BooksDetailsMaster, Integer>,JpaSpecificationExecutor<BooksDetailsMaster>{
	//extends JpaRepository<BooksDetailsMaster, Integer> {

	List<BooksDetailsMaster> findByAuthor(String author);
	List<BooksDetailsMaster> findBySubjectCategory(String subjectCategory);
}
