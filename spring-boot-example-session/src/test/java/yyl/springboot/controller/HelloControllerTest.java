
package yyl.springboot.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MockServletContext.class)
public class HelloControllerTest {

	private MockMvc mvc;
	private MockHttpSession session;

	@Before
	public void setHello() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
		session = new MockHttpSession();
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/hello").accept(MediaType.APPLICATION_JSON_UTF8).session(session))//
				.andExpect(MockMvcResultMatchers.status().isOk())//
				.andDo(MockMvcResultHandlers.print())//
				.andReturn().getResponse();
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON_UTF8).session(session))//
				.andExpect(MockMvcResultMatchers.status().isOk())//
				.andDo(MockMvcResultHandlers.print())//
				.andReturn();
	}
}