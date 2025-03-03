
package yyl.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ThymeleafApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void testHome() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity("/", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).contains("<title>list</title>");
		assertThat(entity.getBody()).doesNotContain("layout:fragment");
	}

	@Test
	public void testCreate() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.set("title", "FOO text");
		map.set("content", "FOO");
		URI location = this.restTemplate.postForLocation("/", map);
		System.out.println(location);
		System.out.println(this.port);
		assertThat(location.toString()).contains("localhost:" + this.port);
	}

	@Test
	public void testCss() {
		ResponseEntity<String> entity = this.restTemplate
				.getForEntity("http://localhost:" + this.port + "/css/bootstrap.min.css", String.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).contains("body");
	}

}
