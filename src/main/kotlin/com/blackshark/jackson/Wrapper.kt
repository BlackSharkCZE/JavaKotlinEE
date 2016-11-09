package com.blackshark.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule
import org.apache.commons.lang3.RandomStringUtils
import java.time.LocalDateTime

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 9.11.16<br/>
 * Time: 11:23<br/>
 */


fun main(args: Array<String>) {

	data class Identity(val id: Long, val name: String, val skipped:String)
	data class Wrapper(val checksum: String, val timestamp: LocalDateTime)

	val mp = ObjectMapper().registerKotlinModule()
			.registerModule(ParameterNamesModule())
			.registerModule(Jdk8Module())
			.registerModule(JavaTimeModule())

	val wrapper = Wrapper(RandomStringUtils.randomAlphabetic(24), LocalDateTime.now())
	val identity = Identity(1, "BlackShark", "HELLO")
	val merged = (mp.readTree(mp.writeValueAsString(wrapper)) as ObjectNode).apply {
		set("data", mp.readTree(mp.writeValueAsString(identity)))
	}

	val skipped = true
	if (skipped) {
		(merged.get("data") as ObjectNode).remove("skipped")
	}

	println(merged)


}
