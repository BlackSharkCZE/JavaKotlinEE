package com.blackshark.rest.dao

import com.blackshark.rest.domain.Identity
import com.blackshark.rest.domain.Role
import java.io.Serializable
import java.util.*
import javax.enterprise.context.ApplicationScoped

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 4.11.16<br/>
 * Time: 7:57<br/>
 */
@ApplicationScoped
open class IdentityDB : Serializable {

	open val idList: ArrayList<Identity> = ArrayList(20)

	private var id = 1L
	private val roles: List<Role> = listOf(Role("ROLE_ADMIN", "Admin role"), Role("ROLE_USER", "User Role"))

	init {
		idList.add(Identity(id++, "Black", "Shark", "blackshark", "123456", roles))
		idList.add(Identity(id++, "Yellow", "Brick", "ybrick", "123456", roles))
		idList.add(Identity(id++, "Orange", "Head", "ohead", "123456", roles))
	}

	open fun save(identity: Identity): Identity? {
		val ident = identity
		idList.add(ident)
		return ident
	}

}
