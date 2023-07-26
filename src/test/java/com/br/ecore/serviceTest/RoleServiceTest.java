package com.br.ecore.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.br.ecore.model.Role;
import com.br.ecore.service.RoleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

	@Autowired
	private RoleService roleservice;

	@Test
	public void CreateRoleTest() {
		assertThat(roleservice.CreateRole(new Role(null, "test")).getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}

	@Test
	public void findAllRolesByMembershipTest() {
		assertThat(roleservice.findAllRolesByMembership("9a1j8s9o-19po-99u7-156t-0kjw82715ch6", 0L)).isNotEmpty();

	}

}
