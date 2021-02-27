package service.Impl;

import mapper.RoleDao;
import mapper.UserDao;
import domain.Role;
import domain.User;
import org.springframework.dao.DataAccessException;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao;
    RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void del(Long userId) {
        userDao.del(userId);
    }

    @Override
    public List<Role> saveUI() {
        return roleDao.findAll();
    }

    @Override
    public List<User> findAll() {
        List<User> all = userDao.findAll();
        for (User user : all) {

            user.setRoleList(roleDao.getList(user.getId()));
        }
        return all;
    }

    @Override
    public User login(String username, String password) {
        try {
            return userDao.login(username,password);
        }
        catch (DataAccessException ex){

           return null;
        }
    }

    @Override
    public void saveUser(User user, Long []ids) {
        Long aLong = userDao.saveUser(user);
        for (Long id : ids) {
            userDao.save(aLong,id);
        }


    }
}
