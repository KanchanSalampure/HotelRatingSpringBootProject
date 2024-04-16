package user.service.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import user.service.entity.user.Users;
@Repository
public interface UserRepository extends JpaRepository<Users,String>{

}
