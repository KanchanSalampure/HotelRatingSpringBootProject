package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import model.Expence;

public interface Mongotinerface extends MongoRepository<Expence,String> {

}
