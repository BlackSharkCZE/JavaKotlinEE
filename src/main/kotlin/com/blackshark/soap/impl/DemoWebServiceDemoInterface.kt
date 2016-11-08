package com.blackshark.soap.impl

import com.blackshark.soap.domain.RequestData
import com.blackshark.soap.domain.ResponseData

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 1.11.16<br/>
 * Time: 12:44<br/>
 */

interface DemoWebServiceDemoInterface {


	fun processData(rData: RequestData): ResponseData

}
