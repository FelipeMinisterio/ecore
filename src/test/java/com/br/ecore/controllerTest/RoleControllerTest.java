package com.br.ecore.controllerTest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.br.ecore.DTO.MembershipDTO;
import com.br.ecore.model.Role;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoleControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void createRoleShouldReturn201CREATED() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/role/create").content(asJsonString(new Role(null, "TEST0")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void findAllRolesByMembershipShouldReturn200Ok() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/role/RoleMembership").content(asJsonString(new MembershipDTO("9a1j8s9o-19po-99u7-156t-0kjw82715ch6",0L)))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
