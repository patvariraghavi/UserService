package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Rating {
	
	public int getID() {
		return ID;
	}

	public String getNAME() {
		return NAME;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Column(name = "name")
	private String NAME;
	
	@Column(name = "address")
	private String ADDRESS;
	
	@Column(name = "gender")
	private String GENDER;


}
