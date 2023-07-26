package com.br.ecore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "role")
@Entity
public class Role {

	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(Long roleId, String roleName) {
		this.id = roleId;
		this.name = roleName;
	}
	
	public Role(Long id) {
		this.id = id;
	}
	

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
