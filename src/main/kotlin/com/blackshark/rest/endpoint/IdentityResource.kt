package com.blackshark.rest.endpoint

import com.blackshark.rest.dao.IdentityDaoInterface
import com.blackshark.rest.domain.CustomSecurityData
import com.blackshark.rest.domain.Identity
import javax.ejb.Stateless
import javax.inject.Inject
import javax.servlet.http.HttpServletRequest
import javax.ws.rs.NotFoundException
import javax.ws.rs.core.SecurityContext

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 5.11.16<br/>
 * Time: 17:58<br/>
 */
@Stateless
open class IdentityResource @Inject constructor(val iDao: IdentityDaoInterface) : IdentityResourceInterface {


	override fun processInject(data: CustomSecurityData): CustomSecurityData = data

	@Throws(NotFoundException::class)
	override fun getByLogin(login: String, servletRequest: HttpServletRequest, securityContext: SecurityContext?): Identity {
		val identity = iDao.findByLogin(login)
		if (identity != null) {
			return identity
		} else {
			throw NotFoundException("Can not find Identity by login $login")
		}
	}
}
