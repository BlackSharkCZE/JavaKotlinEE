package com.blackshark.rest.endpoint.subresource

import org.blackshark.ts.Configuration
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: Jiri Pejsa<br/>
 * Date: 11.11.16<br/>
 * Time: 11:43<br/>
 * <p>To change this template use File | Settings | File Templates.</p>
 */
@Path(Configuration.Rest.CHILD_1_ENDPOINT)
interface Child1ResourceInterface {

	@GET
	@Path("{id: \\d+}")
	@Produces(MediaType.TEXT_PLAIN)
	fun process(@PathParam("id") id: Long): String

}
