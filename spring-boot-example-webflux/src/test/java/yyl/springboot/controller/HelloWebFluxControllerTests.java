package yyl.springboot.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = MockServletContext.class)
public class HelloWebFluxControllerTests {

	private MockMvc mvc;

	@BeforeEach
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloWebFluxController()).build();
	}

	@Test
	public void helloTest() throws Exception {
		perform("/hello", MediaType.APPLICATION_JSON);
	}

	@Test
	public void monoTest() throws Exception {
		perform("/mono", MediaType.APPLICATION_JSON);
	}

	@Test
	public void fluxTest() throws Exception {
		perform("/flux", MediaType.APPLICATION_JSON);
	}

	@Test
	public void streamTest() throws Exception {
		perform("/stream", MediaType.APPLICATION_NDJSON);
	}

	private void perform(String uri, MediaType mediaType) throws Exception {
		mvc.perform(MockMvcRequestBuilders.get(uri).accept(mediaType))//
				.andExpect(MockMvcResultMatchers.status().isOk())//
				.andDo(MockMvcResultHandlers.print())//
				.andReturn();
	}
}