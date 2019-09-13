package com.pixogram.pixogram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@SequenceGenerator(name = "seq1", initialValue = 1, allocationSize = 100)
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	private long id;

	@Column(name="user_name")
	private String name;

	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

	public UserDetails(String name, String email, String password) {
		
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserDetails() {
		
	}
	
	

}