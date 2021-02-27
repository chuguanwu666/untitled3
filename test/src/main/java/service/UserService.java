package service;

import domain.Role;
import domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<Role> saveUI();
    void saveUser(User user,Long []ids);
    void del(Long userId);
    User login(String username,String password);
}
