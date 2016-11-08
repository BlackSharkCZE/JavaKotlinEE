package com.blackshark.rest.dao

import com.blackshark.rest.domain.Identity
import javax.ejb.Stateless
import javax.enterprise.inject.Alternative
import javax.inject.Inject

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 4.11.16<br/>
 * Time: 7:56<br/>
 */
@Stateless
@Alternative
open class IdentityDaoMock @Inject constructor(val identityDB: IdentityDB) : IdentityDaoInterface {

	override fun findByLogin(login: String): Identity? = identityDB.idList.filter { it.login == login }.firstOrNull()

}
