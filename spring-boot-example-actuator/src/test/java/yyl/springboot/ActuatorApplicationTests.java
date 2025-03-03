package yyl.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ActuatorApplicationTests {

	@Autowired
	protected WebApplicationContext wac;
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); // 初始化MockMvc对象
	}

	@Test
	public void contextLoads() throws Exception {
		String responseString = mockMvc.perform(get("/actuator")//
				.contentType(MediaType.APPLICATION_FORM_URLENCODED))//
				.andExpect(status().isOk()) // 返回的状态是200
				.andDo(print())// 打印出请求和响应的内容
				.andReturn()//
				.getResponse().getContentAsString(); // 将响应的数据转换为字符串
		System.out.println(responseString);
	}
}
