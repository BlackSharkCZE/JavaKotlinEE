package com.blackshark.rest.interceptor

import com.blackshark.rest.domain.CustomSecurityData
import org.apache.commons.lang3.RandomStringUtils
import org.jboss.resteasy.spi.ResteasyProviderFactory
import javax.annotation.Priority
import javax.ws.rs.Priorities
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.ext.Provider

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: Jiri Pejsa<br/>
 * Date: 11.11.16<br/>
 * Time: 11:29<br/>
 * <p>To change this template use File | Settings | File Templates.</p>
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
open class CustomSecurityContext : ContainerRequestFilter {

	override fun filter(ctx: ContainerRequestContext) {
		ResteasyProviderFactory.pushContext(CustomSecurityData::class.java, CustomSecurityData(
				RandomStringUtils.randomAlphabetic(64), RandomStringUtils.randomAlphabetic(8)
		))
	}
}
