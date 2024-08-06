package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Table(name = "micro_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

	@Id
	@Column(name = "ID")
	private String UserId;

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", name=" + name + ", email=" + email + ", about=" + about + "]";
	}

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	public User(String userId, String name, String email, String about) {
		super();
		UserId = userId;
		this.name = name;
		this.email = email;
		this.about = about;
	}

	public User() {
		super();
	}

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
