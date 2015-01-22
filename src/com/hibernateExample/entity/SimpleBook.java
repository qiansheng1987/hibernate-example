package com.hibernateExample.entity;

import java.util.List;

/**
 * SimpleBook entity. @author MyEclipse Persistence Tools
 */

public class SimpleBook implements java.io.Serializable {

	// Fields

	private Long id;
	private String description;
	private String name;
	private String url;
	
	private List email;

	// Constructors

	public List getEmail() {
    	return email;
    }

	public void setEmail(List email) {
    	this.email = email;
    }

	/** default constructor */
	public SimpleBook() {
	}

	/** minimal constructor */
	public SimpleBook(String name, String url) {
		this.name = name;
		this.url = url;
	}

	/** full constructor */
	public SimpleBook(String description, String name, String url) {
		this.description = description;
		this.name = name;
		this.url = url;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}