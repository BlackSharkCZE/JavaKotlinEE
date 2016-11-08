package com.blackshark.soap.domain

import java.io.Serializable
import java.util.*
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 1.11.16<br/>
 * Time: 12:42<br/>
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class ResponseData : Serializable {

	@XmlElement(required = true)
	var id: Long? = null

	@XmlElement(required = true, nillable = true)
	var name: String? = null

	@XmlElement
	var tags: ArrayList<String> = ArrayList()

	override fun toString(): String {
		return "ResponseData(id=$id, name=$name)"
	}


}
