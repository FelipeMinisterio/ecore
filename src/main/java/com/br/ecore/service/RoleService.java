package com.br.ecore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.ecore.model.Role;
import com.br.ecore.repository.IRoleRepository;

@Service
public class RoleService {

	@Autowired
	private IRoleRepository repository;

	public ResponseEntity<String> CreateRole(Role role) {
		try {
			role.setId((long) repository.findAll().size());
			repository.save(role);
			return ResponseEntity.status(HttpStatus.CREATED).body("Created Succesfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't create role");
		}
	}
	
	public List<Role> findAllRolesByMembership(String userId, Long teamId) {
		try {
			return repository.findAllRolesByMembership(userId, teamId);
		} catch (Exception e) {
			return null;
		}
	}

}
