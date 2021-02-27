package mapper;

import domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();
    void Save(Role role);
    List<Role> getList(Long l);
}
