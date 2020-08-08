/**
 * 
 */
package com.hcl.libraryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.libraryservice.data.UserDetails;

/**
 * @author gowtham.v
 *
 * 08-Aug-2020 2:12:17 pm
 */
@Repository
public interface UserDetailsRepository 
	//extends PagingAndSortingRepository<UserDetails, Integer>,JpaSpecificationExecutor<UserDetails>{
	extends JpaRepository<UserDetails, Integer> {

}
