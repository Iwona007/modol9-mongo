package iwona.pl.modol9mongo.start;


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

    @EventListener(ApplicationReadyEvent.class)
    public void execute() {
        dataService.deleteAll();
        dataService.readData(); //3.0, 2.0, 3.0
//        dataService.addData(); // 46.0
        dataService.save(dataService.getDataList()); //103., 348.0
        dataService.findAll();// 51.0, 55.0
    }


// czas dla mongo db 862,0 misec sec
}
