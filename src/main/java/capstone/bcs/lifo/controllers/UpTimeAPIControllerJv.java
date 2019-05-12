package capstone.bcs.lifo.controllers;


import capstone.bcs.lifo.services.UptimeBoardcastImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController
public class UpTimeAPIControllerJv {

    /**
     * this is the first attempt at api style information
     * it just measures uptime using a task scheduler event
     * The java version is disabled and the kotlin version is
     * currently running
     */

    private UptimeBoardcastImpl uptimeBoardcast;

    @Autowired
    public UpTimeAPIControllerJv(UptimeBoardcastImpl uptimeBoardcast){
        this.uptimeBoardcast = uptimeBoardcast;
    }

    @RequestMapping("/uptime")
    public List<String> uptime(){
        List<String> uptime2 = new ArrayList<>();
        if(uptimeBoardcast.getUptime() != null)
        return uptimeBoardcast.getUptime();
        else
        {
            uptime2 = new ArrayList<>();
            uptime2.add("less than 30 seconds");
            return uptime2;
        }
    }

}
