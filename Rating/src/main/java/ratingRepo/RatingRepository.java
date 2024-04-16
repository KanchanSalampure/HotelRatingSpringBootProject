package ratingRepo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import rating.entity.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

List<Rating> findByUserid(String userid);
List<Rating> findByHotel(String hotel);





}
