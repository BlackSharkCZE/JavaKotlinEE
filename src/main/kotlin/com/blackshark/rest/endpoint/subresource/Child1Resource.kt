package com.blackshark.rest.endpoint.subresource


class Child1Resource : Child1ResourceInterface {

	override fun process(id:Long): String {
		return "$id : ${this.javaClass.simpleName}"
	}
}
