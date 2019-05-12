package capstone.bcs.lifo.services;

import java.util.List;

public interface UptimeBroadcastService {

    /**
     * Interface for the UptimeBroadcastService
     * This is to follow best practices with regard to SOLID
     *
     */

    void broadcastUptime();

    List<String> getUptime();


}
