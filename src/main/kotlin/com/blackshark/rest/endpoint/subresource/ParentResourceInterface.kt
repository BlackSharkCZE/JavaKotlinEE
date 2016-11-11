package com.blackshark.rest.endpoint.subresource

import org.blackshark.ts.Configuration
import javax.ws.rs.Path

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: Jiri Pejsa<br/>
 * Date: 11.11.16<br/>
 * Time: 11:41<br/>
 * <p>To change this template use File | Settings | File Templates.</p>
 */
@Path(Configuration.Rest.PARENT_ENDPOINT)
interface ParentResourceInterface {

	@Path("child1")
	fun processChild1():Child1ResourceInterface

	@Path("child2")
	fun processChild2(): Child2ResourceInterface

}
