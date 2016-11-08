package com.blackshark.soap.beans

import com.blackshark.soap.domain.RequestData
import com.blackshark.soap.domain.ResponseData

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 1.11.16<br/>
 * Time: 12:49<br/>
 */
interface DemoBeanInterface {

	fun processData(input: RequestData): ResponseData

}
