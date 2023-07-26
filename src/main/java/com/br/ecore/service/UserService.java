package com.br.ecore.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.ecore.DTO.MembershipDTO;
import com.br.ecore.model.User;
import com.br.ecore.repository.IUserRepository;

@Service
public class UserService {

	@Autowired
	private IUserRepository userRepository;

	public List<MembershipDTO> findAllMembershipByRole(Long roleId) {
		try {
			List<User> list = userRepository.findAllMembershipByRole(roleId);
			List<MembershipDTO> listDTO = new ArrayList<MembershipDTO>();
			ModelMapper mp = new ModelMapper();
			for (User user : list) {
				MembershipDTO memberShipDTO = mp.map(user, MembershipDTO.class);
				listDTO.add(memberShipDTO);
			}
			return listDTO;
		} catch (Exception e) {
			return null;
		}

	}

	public ResponseEntity<String> AssignedRoleToTeamMember(String userId, Long roleId, Long teamId) {
		User user = userRepository.findTeamMemberById(userId, teamId);
		try {
			userRepository.saveAndFlush(new User(user.getId(), user.getName(), roleId, user.getTeam().getId()));
			return ResponseEntity.status(HttpStatus.OK).body("Assigned Succesfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Assigned Failed");
		}
	}

}
