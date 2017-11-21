package yyl.spring.boot.restful;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;

public class RestResourceTest {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:80/rest/hello");

		Response response = target.request().get();

		//Basic Authentication
		//Response response = target.register(HttpAuthenticationFeature.basicBuilder().credentials("username", "password").build()).request().get();

		Assert.assertEquals(200, response.getStatus());
		Map<String, Object> map = response.readEntity(new GenericType<Map<String, Object>>() {
		});
		System.out.println(map);

	}

	@Test
	public void testBasicPreemptive() {
	}
}
