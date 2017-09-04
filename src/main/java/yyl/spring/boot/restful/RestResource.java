package yyl.spring.boot.restful;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Path("/")
@Component
public class RestResource {

	//~ /rest/hello
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/hello")
	public Map<String, Object> hello() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "200");
		map.put("message", "hello restful & jersey");
		return map;
	}
}