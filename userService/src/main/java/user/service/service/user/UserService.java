package user.service.service.user;

import java.util.List;

import user.service.entity.user.Users;

public interface UserService {
Users saveuser(Users user);
List<Users>getallUsers();
Users getusers(String id);
}
