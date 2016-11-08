package com.blackshark.rest.domain

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 4.11.16<br/>
 * Time: 7:51<br/>
 */
data class Role(val name: String, val descr: String)

data class Identity constructor(
		val id: Long? = null,
		var firstName: String,
		var lastName: String,
		var login: String,
		@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
		var passwd: String? = null,
		var roles: List<Role> = mutableListOf())

