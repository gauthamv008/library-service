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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author gowtham.v
 *
 * 08-Aug-2020 1:44:24 pm
 */
//@Entity
//@Table(name="user_roles", uniqueConstraints={@UniqueConstraint(columnNames = {"user_id" , "role_id"})})
public class UserRoleDetails {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserDetails userDetails;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "roleDetails", orphanRemoval = true)
	@JoinColumn(name="role_id")
	Set<RoleDetails> rolesFeatures = new HashSet<RoleDetails>();

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Set<RoleDetails> getRolesFeatures() {
		return rolesFeatures;
	}

	public void setRolesFeatures(Set<RoleDetails> rolesFeatures) {
		this.rolesFeatures = rolesFeatures;
	}

}
