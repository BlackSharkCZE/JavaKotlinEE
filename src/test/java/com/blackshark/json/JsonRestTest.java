package com.blackshark.json;

import com.blackshark.Post;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static javax.ws.rs.client.ClientBuilder.newClient;

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 26.10.16<br/>
 * Time: 20:29<br/>
 */
public class JsonRestTest {


	@Test
	public void testProcessJSON() throws Exception {
		final String s = newClient()
				.target("http://jsonplaceholder.typicode.com/posts")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.get().readEntity(String.class);
		System.out.println(s);
	}

	@Test
	public void testPojoProcess() throws Exception {

		GenericType<List<Post>> gType = new GenericType<List<Post>>() {
		};
		List<Post> res = ClientBuilder.newClient()
				.target("http://jsonplaceholder.typicode.com/posts")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.get().readEntity(gType);
		System.out.println(res);
	}

	@Test
	public void testPostKotlinIntegration() throws Exception {
		final Post2 p = new Post2(154L, "Lanista ridetiss, tanquam placidus domina.", "Lamias peregrinationes! Hydras congregabo in varius palatium!", null);
		String res = ClientBuilder.newClient()
				.target("http://jsonplaceholder.typicode.com/posts")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(p, MediaType.APPLICATION_JSON_TYPE)).readEntity(String.class);
		System.out.println(res);
	}


	@Test
	public void testPost() throws Exception {
		final Post p = new Post();
		p.setBody("Lamias peregrinationes! Hydras congregabo in varius palatium!");
		p.setTitle("Lanista ridetiss, tanquam placidus domina.");
		p.setUserId(154L);

		String res = ClientBuilder.newClient()
				.target("http://jsonplaceholder.typicode.com/posts")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(p, MediaType.APPLICATION_JSON_TYPE)).readEntity(String.class);
		System.out.println(res);

	}

	@Test
	public void testPostJSON() throws Exception {

		final String data = "{\n" +
				"  \"userId\": 154,\n" +
				"  \"title\": \"Lanista ridetiss, tanquam placidus domina.\",\n" +
				"  \"body\": \"Lamias peregrinationes! Hydras congregabo in varius palatium!\"\n" +
				"}";
		String res = ClientBuilder.newClient()
				.target("http://jsonplaceholder.typicode.com/posts")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(data, MediaType.APPLICATION_JSON_TYPE)).readEntity(String.class);
		System.out.println(res);

	}
}
