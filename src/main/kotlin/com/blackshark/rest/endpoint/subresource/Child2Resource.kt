package com.blackshark.rest.endpoint.subresource


class Child2Resource : Child2ResourceInterface {

	override fun process(id:Long): String {
		return "$id : ${this.javaClass.simpleName}"
	}
}
