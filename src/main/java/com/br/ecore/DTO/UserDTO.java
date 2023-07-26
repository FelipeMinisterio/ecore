package com.br.ecore.DTO;

public class UserDTO {

	public UserDTO(String userId, Long roleId, Long teamId) {
		this.id = userId;
		this.roleId = roleId;
		this.teamId = teamId;
	}

	private String id;
	private Long roleId;
	private Long teamId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

}
