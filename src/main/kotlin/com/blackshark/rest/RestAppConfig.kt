package org.blackshark.ts

import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

/**
 * <strong>Created with IntelliJ IDEA</strong><br/>
 * User: BlackShark<br/>
 * Date: 5.11.16<br/>
 * Time: 17:55<br/>
 */
@ApplicationPath(Configuration.REST_PATH)
open class RestAppConfig : Application()
