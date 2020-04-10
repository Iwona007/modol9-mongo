package iwona.pl.modol9mongo.repository;


import iwona.pl.modol9mongo.model.Data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepo extends MongoRepository<Data, String> {
}
