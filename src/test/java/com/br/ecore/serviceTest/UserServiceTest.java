package com.br.ecore.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.ecore.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	
	@Autowired
	private UserService userService;
	
	@Test
	public void findAllMembershipByRoleTest() {
		assertThat(userService.findAllMembershipByRole(1L)).isNotEmpty();		
	}
	
	@Test
	public void AssignedRoleToTeamMemberTest() {
		assertThat(userService.AssignedRoleToTeamMember("9a1j8s9o-19po-99u7-156t-0kjw82715ch6", 1l, 0l).getStatusCode()).isEqualTo(HttpStatus.OK);	

	}
	
}
