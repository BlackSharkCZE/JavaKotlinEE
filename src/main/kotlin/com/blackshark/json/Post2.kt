package com.blackshark.json

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 27.10.16<br/>
 * Time: 12:58<br/>
 */
class Post2(val userId: Long? = null, val title: String? = null, val body: String? = null, val id: Long? = null) {

    constructor(userId: Long) : this(userId,null,null,null)

    override fun toString(): String {
        return "Post2{id:$id, title:\"$title\"}"
    }
}
