package com.springBoot_project_1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@Column(unique=true)
	private String email;
	
	@Column(length=500)
	private String about;
	
	private String password;
	
	@Column(length=10,unique=true)
	private String phoneNumber;
	
	private Boolean enabled;
	private String role;
	private String imageUrl;
	
	
	
	public User(int id, String name, String email, String about, String password, String phoneNumber, Boolean enabled,
			String role, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.about = about;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.enabled = enabled;
		this.role = role;
		this.imageUrl = imageUrl;
	}



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", about=" + about + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + ", enabled=" + enabled + ", role=" + role + ", imageUrl=" + imageUrl
				+ "]";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
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



	public String getAbout() {
		return about;
	}



	public void setAbout(String about) {
		this.about = about;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public Boolean getEnabled() {
		return enabled;
	}



	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}
