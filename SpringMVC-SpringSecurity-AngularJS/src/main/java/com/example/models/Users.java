package com.example.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;

	@Basic(optional = false)
	@Length(max = 50)
	@Column(name = "username")
	private String username;

	@Basic(optional = false)
	@Column(name = "password")
	private String password;

	@Basic(optional = false)
	@Length(max = 50)
	@Column(name = "active")
	private String active;

	// @JoinColumn(name = "id", referencedColumnName = "id_user", insertable =
	// false, updatable = false)
	// @OneToOne(optional = false)
	// private Customer customer;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	public Users() {
	}

	public Users(Long id) {
		this.id = id;
	}

	public Users(Long id, String username, String password, String active) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.active = active;
	}

	public Users(String username, String password, String active) {
		this.username = username;
		this.password = password;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// public Customer getCustomer() {
	// return customer;
	// }
	//
	// public void setCustomer(Customer customer) {
	// this.customer = customer;
	// }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
}