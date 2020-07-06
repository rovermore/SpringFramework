package com.bolsadeideas.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.bolsadeideas.springboot.form.app.validators.IdentificatorRegex;
import com.bolsadeideas.springboot.form.app.validators.Required;

public class User {
	
	//@Pattern(regexp="[0-9]{2}[-.][0-9a-zA-Z]{3}[-.][0-9]{2}")
	@IdentificatorRegex
	private String id;

	//@NotEmpty
	private String name;
	
	//@NotBlank
	@Required
	private String surname;
	
	@NotBlank(message = "escribe un nombre de usuario")
	private String username;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotBlank
	@Size(min = 3, max = 12)
	private String password;
	
	@NotNull
	private Integer account;
	
	private Country country;
	
	@NotNull
	@FutureOrPresent
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date date;
	
	@NotNull
	private List<Role> roles;
	
	private Boolean setupUser = true;
	
	private String gender;

	public User() {}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getSetupUser() {
		return setupUser;
	}

	public void setSetupUser(Boolean setupUser) {
		this.setupUser = setupUser;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
