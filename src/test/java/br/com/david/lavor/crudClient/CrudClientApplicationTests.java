package br.com.david.lavor.crudClient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class CrudClientApplicationTests {

	@Autowired
	MockMvc mock;

	@Test
	@WithMockUser(username = "admin", password = "password", roles = "ADMIN")
	void testMockgetClientstatusOk()
			throws Exception {
		mock.perform(get("/client/get")).andExpect(status().isOk());
	}

	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	void testMockgetClientstatusforbidden()
			throws Exception {
		mock.perform(get("/client/get")).andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	void testMockPostClientstatusAccepted()
			throws Exception {
		mock.perform(
				post("/client/add")
						.content("{\n" +
								"\"nome\" : \"asafe\",\n" +
								"\"cpf\" : \"001806653213\",\n" +
								"\"endereco\" : \"aquimesmo\"\n" +
								"}")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());
	}

	@Test
	@WithMockUser(username = "admin", password = "password", roles = "ADMIN")
	void testMockPostClientstatusforbidden()
			throws Exception {
		mock.perform(
				post("/client/add")
						.content("{\n" +
								"\"nome\" : \"asafe\",\n" +
								"\"cpf\" : \"001806653213\",\n" +
								"\"endereco\" : \"aquimesmo\"\n" +
								"}")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isForbidden());
	}
}
