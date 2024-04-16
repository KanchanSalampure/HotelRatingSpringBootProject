package hotel.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotel.entity.Hotel;
@Repository
public interface HotelRepositry extends JpaRepository<Hotel,String> {

}
