package com.br.ecore.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.ecore.model.User;



public interface IUserRepository extends JpaRepository<User, String> {

	@Query(value = "SELECT U.id, U.name, U.role_Id, U.team_Id as team_Id FROM users U INNER JOIN team T ON U.team_Id = T.id WHERE U.role_Id = ?1", nativeQuery = true)	
	List<User> findAllMembershipByRole(Long roleId);
	
	@Query(value = " SELECT U.id, U.name, U.role_Id, U.team_Id FROM users U INNER JOIN team T on U.team_Id = T.id WHERE U.id = ?1 AND T.id = ?2 ", nativeQuery = true)
	User findTeamMemberById(String userId, Long teamId);
	
}
