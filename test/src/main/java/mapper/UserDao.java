package mapper;

import domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    Long saveUser(User user);
    void save(Long userId,Long roleId);
    void del(Long userId);
    User login(String username,String password);
}
