package com.br.ecore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
public class User {

	public User(String userId, String userName, Long roleId, Long teamId) {
		this.id = userId;
		this.name = userName;
		if (role == null) {
			role = new Role();
			this.getRole().setId(roleId);
		}
		if (team == null) {
			team = new Team();
			this.getTeam().setId(teamId);
		}
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(name = "name")
	private String name;

	@JsonAlias("roleId")
	@JsonProperty
	@ManyToOne
	@JoinColumn(name = "roleId")
	private Role role;

	@JsonAlias("teamId")
	@JsonProperty
	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team team;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

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

}
