package com.blackshark.rest.endpoint.subresource

import javax.ejb.Stateless
import javax.inject.Inject


@Stateless
open class ParentResource : ParentResourceInterface {

	@Inject
	lateinit var ch1: Child1ResourceInterface

	@Inject
	lateinit var ch2: Child2ResourceInterface


	override fun processChild1(): Child1ResourceInterface {
		return ch1
	}

	override fun processChild2(): Child2ResourceInterface {
		return ch2;
	}
}
