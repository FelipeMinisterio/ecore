package com.br.ecore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ecore.DTO.MembershipDTO;
import com.br.ecore.DTO.UserDTO;
import com.br.ecore.model.Role;
import com.br.ecore.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PutMapping("/assign")
	public ResponseEntity<String> AssignedRoleToTeamMember(@RequestBody UserDTO user) {
		return userService.AssignedRoleToTeamMember(user.getId(), user.getRoleId(), user.getTeamId());
	}

	@GetMapping("/membershipRole")
	public ResponseEntity<List<MembershipDTO>> findAllMembershipByRole(@RequestBody Role role) {
		List<MembershipDTO> membershipList = userService.findAllMembershipByRole(role.getId());
		if (!membershipList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findAllMembershipByRole(role.getId()));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(membershipList);
		}
	}
}
