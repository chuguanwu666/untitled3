package service.Impl;

import mapper.RoleDao;
import domain.Role;
import service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void Save(Role role) {
        roleDao.Save(role);
    }
}
