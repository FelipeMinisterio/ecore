package com.br.ecore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ecore.DTO.MembershipDTO;
import com.br.ecore.model.Role;
import com.br.ecore.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleservice;

	@PostMapping("/create")
	public ResponseEntity<String> createRole(@RequestBody Role role) {
		return roleservice.CreateRole(role);
	}

	@GetMapping("/RoleMembership")
	public ResponseEntity<List<Role>> findAllRolesByMembership(@RequestBody MembershipDTO msDTO) {
		List<Role> membershipList = roleservice.findAllRolesByMembership(msDTO.getUserId(), msDTO.getTeamId());
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(roleservice.findAllRolesByMembership(msDTO.getUserId(), msDTO.getTeamId()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(membershipList);
		}
	}
}
