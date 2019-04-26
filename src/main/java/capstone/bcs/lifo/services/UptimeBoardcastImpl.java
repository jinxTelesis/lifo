package capstone.bcs.lifo.services;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UptimeBoardcastImpl implements UptimeBroadcastService {


    // this would normally be an int but wanted something to transfer between sister site via api
    // as json or xml
    private List<String> uptime = new ArrayList<>();

    //private RestTemplate restTemplate;

    //public UptimeBoardcastImpl(RestTemplate restTemplate){
    //    this.restTemplate = restTemplate;
    //}


    @Scheduled(fixedRate = 3000)
    @Override
    public void broadcastUptime() {

        if(uptime.size() == 0)
        {
            String first = "30";
            uptime.add(first);
        }else
        {
            int uptimeCount = (uptime.size() * 30) + 30;
            String afterFirst = Integer.toString(uptimeCount);
            uptime.add(afterFirst);
        }

        int index = uptime.size() -1;
        System.out.println(uptime.get(index));
    }

    @Override
    public List<String> getUptime() {
        return this.uptime;
    }


}
