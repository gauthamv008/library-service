/**
 * 
 */
package com.hcl.libraryservice.service;

import com.hcl.libraryservice.data.UserDetails;

/**
 * @author gowtham.v
 *
 * 08-Aug-2020 2:40:32 pm
 */
public interface UserDetailsService {

	public UserDetails getUserDetails(Integer userId, String privilages);
	
}
