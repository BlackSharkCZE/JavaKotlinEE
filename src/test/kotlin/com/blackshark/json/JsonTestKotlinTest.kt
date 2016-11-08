package com.blackshark.json

import com.blackshark.Post
import org.junit.Test
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.client.ClientBuilder.newClient
import javax.ws.rs.client.Entity
import javax.ws.rs.core.GenericType
import javax.ws.rs.core.MediaType

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 27.10.16<br/>
 * Time: 13:11<br/>
 */
class JsonTestKotlinTest {

	@Test
	fun testProcessJSON() {
		val s = newClient()
				.target("http://jsonplaceholder.typicode.com/posts")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.get().readEntity(String::class.java)
		println(s)
	}

	@Test
	fun testProcessJSONKotlinSyn() {
		println(
				with(newClient(), {
					target("http://jsonplaceholder.typicode.com/posts")
							.request(MediaType.APPLICATION_JSON_TYPE)
							.get().readEntity(String::class.java)
				}))
	}

	@Test
	@Throws(Exception::class)
	fun testPojoProcess() {
		val gType = object : GenericType<List<Post>>() {}
		val res = ClientBuilder
				.newClient()
				.target("http://jsonplaceholder.typicode.com/posts")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.get()
				.readEntity(gType)
		println(res)
	}

	@Test
	@Throws(Exception::class)
	fun testPostKotlinIntegration() {

		val p = Post2(154L, "Lanista ridetiss, tanquam placidus domina.", "Lamias peregrinationes! Hydras congregabo in varius palatium!", null)
		val res = newClient()
				.target("http://jsonplaceholder.typicode.com/posts")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(p, MediaType.APPLICATION_JSON_TYPE))
				.readEntity(String::class.java)
		println(res)
	}

	@Test
	@Throws(Exception::class)
	fun testPostKotlinSyntax() {
		val res = newClient()
				.target("http://jsonplaceholder.typicode.com/posts")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(Post().apply {
					body = "Lamias peregrinationes! Hydras congregabo in varius palatium!"
					title = "Lanista ridetiss, tanquam placidus domina."
					userId = 154L
				}, MediaType.APPLICATION_JSON_TYPE))
				.readEntity(String::class.java)
		println(res)
	}


	@Test
	@Throws(Exception::class)
	fun testPost() {
		val p = Post()
		p.body = "Lamias peregrinationes! Hydras congregabo in varius palatium!"
		p.title = "Lanista ridetiss, tanquam placidus domina."
		p.userId = 154L
		val res = newClient()
				.target("http://jsonplaceholder.typicode.com/posts")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(p, MediaType.APPLICATION_JSON_TYPE))
				.readEntity(String::class.java)
		println(res)
	}

	@Test
	@Throws(Exception::class)
	fun testPostJSON() {
		val data = "{\n" +
				"  \"userId\": 154,\n" +
				"  \"title\": \"Lanista ridetiss, tanquam placidus domina.\",\n" +
				"  \"body\": \"Lamias peregrinationes! Hydras congregabo in varius palatium!\"\n" +
				"}"
		val res = newClient()
				.target("http://jsonplaceholder.typicode.com/posts")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(data, MediaType.APPLICATION_JSON_TYPE))
				.readEntity(String::class.java)
		println(res)
	}


	@Test
	fun testEmptyKotlinSyntax() {
		val d: Array<Post2> = arrayOf(Post2(userId = 101, title = "Hello World"), Post2(userId = 89, title = "Humani generiss tolerare!"))
		val filter = d.filter { it.userId?.compareTo(10) == 1 }

		d.map { it.userId }.forEach(::println)

		println(filter)
	}
}
