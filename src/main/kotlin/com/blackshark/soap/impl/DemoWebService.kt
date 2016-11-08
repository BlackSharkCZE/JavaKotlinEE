package com.blackshark.soap.impl

import com.blackshark.soap.beans.DemoBeanInterface
import com.blackshark.soap.domain.RequestData
import com.blackshark.soap.domain.ResponseData
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.jws.WebMethod
import javax.jws.WebParam
import javax.jws.WebResult
import javax.jws.WebService

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 1.11.16<br/>
 * Time: 12:47<br/>
 */
@WebService(serviceName = "demoService", name = "DemoWebService", portName = "demoServicePort", targetNamespace = "com.blackshark")
open class DemoWebService : DemoWebServiceDemoInterface {

	@Inject
	lateinit var bean: DemoBeanInterface

	companion object {
		val logger: Logger = LoggerFactory.getLogger(DemoWebService::class.java)
	}

	@WebMethod(operationName = "processData")
	@WebResult(name = "responseData")
	override fun processData(@WebParam(name = "requestData") rData: RequestData): ResponseData {
		logger.debug("Data: $rData")
		return bean.processData(rData)
	}
}
