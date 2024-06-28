package com.example.demo.entity;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Entity
@Table(name = "micro_user")
public class User {
	
	
	

	@Id
	@Column(name = "ID")
	private String UserId;
	
	@Column(name = "NAME")
	private String name ;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ABOUT")
	private String about;

	public String getUserId() {
		return UserId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getAbout() {
		return about;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAbout(String about) {
		this.about = about;
	}



	


	
	

	
	

	
	
}
