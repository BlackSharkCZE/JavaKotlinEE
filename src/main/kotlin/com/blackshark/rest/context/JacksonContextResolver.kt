package com.blackshark.rest.context

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import javax.ws.rs.Consumes
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.ContextResolver
import javax.ws.rs.ext.Provider

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 8.11.16<br/>
 * Time: 9:13<br/>
 */
@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
open class JacksonContextResolver : ContextResolver<ObjectMapper> {

	private val om: ObjectMapper

	init {
		om = ObjectMapper()
		om.registerModule(KotlinModule())
				.registerModule(ParameterNamesModule())
				.registerModule(Jdk8Module())
				.registerModule(JavaTimeModule())
				.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
	}


	override fun getContext(clazz: Class<*>) : ObjectMapper {
		return om
	}
}
