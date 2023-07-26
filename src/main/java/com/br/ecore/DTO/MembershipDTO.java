package com.br.ecore.DTO;

public class MembershipDTO {

	public MembershipDTO(String idUser, Long idTeam) {
		this.userId = idUser;
		this.teamId = idTeam;
	}

	public MembershipDTO() {

	}

	private String userId;

	private Long teamId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

}
