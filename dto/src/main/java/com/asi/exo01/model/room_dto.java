package com.asi.exo01.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class room_dto {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String surname;
	private String pwd;
	private String name;
	private float balance;
	
	public room_dto(String surname, String pwd, String name, float solde) {
		super();
		this.surname = surname;
		this.pwd = pwd;
		this.name = name;
		this.balance = solde;
	}
	
	public room_dto() {
		
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSolde() {
		return balance;
	}

	public void setSolde(float solde) {
		this.balance = solde;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String nom) {
		this.name = nom;
	}
}
