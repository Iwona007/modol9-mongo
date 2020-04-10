package iwona.pl.modol9mongo.service;

import iwona.pl.modol9mongo.model.Data;
import iwona.pl.modol9mongo.repository.DataRepo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DataService {

    private static final String FILENAME = "src/main/resources/mockdata.csv";
    private List<Data> dataList;
    private DataRepo dataRepo;

    public DataService(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
        this.dataList = new ArrayList<>();
    }

    public void readData() {
        BufferedReader read = null;
        String nextLine = null;
        int line = 0;

        try {
            read = new BufferedReader(new FileReader(FILENAME));
            while ((nextLine = read.readLine()) != null) {
                String[] data1 = nextLine.split(",");
                Data data = new Data(
                        data1[0],
                        data1[1],
                        data1[2],
                        data1[3],
                        data1[4],
                        data1[5]);
                dataList.add(data);
                line++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Data> addData() {
        for (int i = 0; i < dataList.size(); i++) {
            dataList.get(i).getId();
            dataList.get(i).getFirstName();
            dataList.get(i).getLastName();
            dataList.get(i).getEmail();
            dataList.get(i).getGender();
            dataList.get(i).getIpAddress();
        }
        return dataRepo.saveAll(dataList);
    }

//    public void findAll() {
//    dataRepo.findAll();
//    }
}
