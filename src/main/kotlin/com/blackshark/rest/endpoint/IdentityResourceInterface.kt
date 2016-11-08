package com.blackshark.rest.endpoint

import org.blackshark.ts.Configuration
import com.blackshark.rest.domain.Identity
import javax.annotation.security.RolesAllowed
import javax.servlet.http.HttpServletRequest
import javax.ws.rs.*
import javax.ws.rs.core.Context
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.SecurityContext

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 5.11.16<br/>
 * Time: 17:56<br/>
 */
@Path(Configuration.Rest.IDENTITY_ENDPOINT)
interface IdentityResourceInterface {

	@Path("{login}")
	@GET
	@Throws(NotFoundException::class)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("ADMIN1")
	fun getByLogin(@PathParam("login") login: String, @Context servletRequest:HttpServletRequest, @Context securityContext: SecurityContext?): Identity

}
