/**
 * 
 */
package com.hcl.libraryservice.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author gowtham.v
 *
 * 08-Aug-2020 1:42:42 pm
 */
@Entity
@Table(name="user_details")
public class UserDetails {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@Column(name ="user_name")
	private String userName;
	
	@Column(name ="user_pass")
	private String userPassword;
	
	/*@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "roleDetails", orphanRemoval = true)
	Set<UserRoleDetails> roleDetails = new HashSet<UserRoleDetails>();
	 */
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/*public Set<UserRoleDetails> getRoleDetails() {
		return roleDetails;
	}

	public void setRoleDetails(Set<UserRoleDetails> roleDetails) {
		this.roleDetails = roleDetails;
	}*/
	
	
}
