
package yyl.springboot.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = MockServletContext.class)
public class HelloControllerTest {

	private MockMvc mvc;
	private MockHttpSession session;

	@BeforeEach
	public void setHello() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
		session = new MockHttpSession();
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/hello").accept(MediaType.APPLICATION_JSON).session(session))//
				.andExpect(MockMvcResultMatchers.status().isOk())//
				.andDo(MockMvcResultHandlers.print())//
				.andReturn().getResponse();
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON).session(session))//
				.andExpect(MockMvcResultMatchers.status().isOk())//
				.andDo(MockMvcResultHandlers.print())//
				.andReturn();
	}
}