package com.blackshark.soap.beans

import com.blackshark.soap.domain.RequestData
import com.blackshark.soap.domain.ResponseData
import java.util.*
import javax.ejb.Stateless

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 1.11.16<br/>
 * Time: 12:47<br/>
 */
@Stateless
open class DemoBean : DemoBeanInterface {

	override fun processData(input: RequestData): ResponseData {
		return ResponseData().apply {
			id = input.id * 2
			name = input.name.toUpperCase()
			tags = ArrayList(input.tags.map(String::toUpperCase))
		}
	}
}
