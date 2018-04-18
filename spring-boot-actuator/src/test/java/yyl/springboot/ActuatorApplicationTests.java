package yyl.springboot;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActuatorApplicationTests {

	@Autowired
	protected WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before()
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
