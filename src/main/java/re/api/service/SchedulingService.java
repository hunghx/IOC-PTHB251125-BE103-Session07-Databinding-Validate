package re.api.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulingService {
    private static int count = 0;
    @Scheduled(fixedRate = 1000)
    @Async
    public void printCount(){
        count++;
        System.out.println("count: "+count);
    }
}
