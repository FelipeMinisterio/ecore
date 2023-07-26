package com.br.ecore.controllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.br.ecore.DTO.UserDTO;
import com.br.ecore.model.Role;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void AssignedRoleToTeamMemberShouldReturn200Ok() throws Exception {
		mvc.perform(MockMvcRequestBuilders.put("/user/assign")
				.content(asJsonString(new UserDTO("9a1j8s9o-19po-99u7-156t-0kjw82715ch6", 1L, 0L)))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void findAllMembershipByRoleShouldReturn200Ok() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/user/membershipRole")
				.content(asJsonString(new Role(1L)))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
