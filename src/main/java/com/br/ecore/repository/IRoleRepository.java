package com.br.ecore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.ecore.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

	@Query(value = "SELECT R.id, R.name FROM role R INNER JOIN users U ON U.role_Id = R.id INNER JOIN team T on U.team_Id = T.id WHERE U.id = ?1 AND T.id = ?2", nativeQuery = true)
	List<Role> findAllRolesByMembership(String userId, Long teamId);
}
