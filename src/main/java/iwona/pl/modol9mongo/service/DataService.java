package iwona.pl.modol9mongo.service;


import iwona.pl.modol9mongo.model.Data;
import iwona.pl.modol9mongo.repository.DataRepo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    private String filename = "D:\\Eryka\\PROGRAMOWANIE\\Spring-Boot-Akademia\\Homework\\modol9\\mockdata.csv";
    private List<Data> dataList;
    private DataRepo dataRepo;

    public DataService(DataRepo dataRepo) throws IOException {
        this.dataRepo = dataRepo;
        dataList = new ArrayList<>();
    }

    @EventListener(ApplicationReadyEvent.class)
    public List<Data> read() {
        List<Data> newList = new ArrayList<>();
        BufferedReader read = null;
        String nextLine = null;
        int line = 0;

        try {
            read = new BufferedReader(new FileReader(filename));
            while ((nextLine = read.readLine()) != null) {
                String[] data1 = nextLine.split(",");
                Data data = new Data(
                        data1[0],
                        data1[1],
                        data1[2],
                        data1[3],
                        data1[4],
                        data1[5]);
                newList.add(data);
                System.out.println(nextLine);
                line++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < newList.size(); i++) {
            newList.get(i).getId();
            newList.get(i).getFirstName();
            newList.get(i).getLastName();
            newList.get(i).getEmail();
            newList.get(i).getGender();
            newList.get(i).getIpAddress();
            System.out.println(newList);
        }
        return dataRepo.saveAll(newList);
    }
}
