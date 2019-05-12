package capstone.bcs.lifo.controllers

import capstone.bcs.lifo.services.UptimeBoardcastImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.ArrayList

@RestController
class UpTimeAPIControllerKt @Autowired
constructor(private val uptimeBoardcast: UptimeBoardcastImpl) {

    /**
     * this is the first attempt at api style information
     * it just measures uptime using a task scheduler event
     */

    @RequestMapping("/uptime")
    fun uptime(): List<String> {
        var uptime2: MutableList<String> = ArrayList()
        if (uptimeBoardcast.uptime != null)
            return uptimeBoardcast.uptime
        else {
            uptime2 = ArrayList()
            uptime2.add("less than 30 seconds")
            return uptime2
        }
    }

}