/**
 * 
 */
package com.hcl.libraryservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.libraryservice.data.UserDetails;
import com.hcl.libraryservice.exception.UserNotFoundException;
import com.hcl.libraryservice.repository.UserDetailsRepository;
import com.hcl.libraryservice.service.UserDetailsService;

/**
 * @author gowtham.v
 *
 * 08-Aug-2020 12:08:47 pm
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserDetailsRepository userDetailsRepo;
	
	public UserDetails getUserDetails(Integer userId, String privilages) {
		
		UserDetails user =  userDetailsRepo.findById(userId).orElseThrow(
				() -> new UserNotFoundException("User is Not found!!!"));
		
		//Need to check User Privilages
		
		return user;
	
	}

}
