package com.blackshark.rest.dao

import com.blackshark.rest.domain.Identity

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 4.11.16<br/>
 * Time: 7:54<br/>
 */
interface IdentityDaoInterface {

	fun findByLogin(login: String) : Identity?

}
