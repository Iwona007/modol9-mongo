package iwona.pl.modol9mongo.start;


import iwona.pl.modol9mongo.aspect.AfterStart;
import iwona.pl.modol9mongo.aspect.AroundStart;
import iwona.pl.modol9mongo.aspect.BeforeStart;
import iwona.pl.modol9mongo.service.DataService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class Start {

    private DataService dataService;

    public Start(DataService dataService) {
        this.dataService = dataService;
    }

//    @BeforeStart
//    @AfterStart
    @AroundStart
    @EventListener(ApplicationReadyEvent.class)
    public void execute() {
    dataService.readData();
    dataService.addData();
    }


// czas dla mongo db 862,0 misec sec
}
