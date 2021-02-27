package mapper.Impl;

import mapper.RoleDao;
import domain.Role;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> findAll() {
 ApplicationContext X=new ClassPathXmlApplicationContext();

        List<Role> roleList = jdbcTemplate.query("select *from sys_role", new BeanPropertyRowMapper<Role>(Role.class));

        return roleList;
    }

    @Override
    public void Save(Role role) {
        jdbcTemplate.update("insert into sys_role values (?,?,?)",null,role.getRoleName(),role.getRoleDesc());
    }
    public List<Role> getList(Long l){
        System.out.println(jdbcTemplate.query("select *from sys_user_role sur,sys_role sr where sur.roleId=sr.id and sur.userId=?",new BeanPropertyRowMapper<Role>(Role.class),l));
        return jdbcTemplate.query("select *from sys_user_role sur,sys_role sr where sur.roleId=sr.id and sur.userId=?",new BeanPropertyRowMapper<Role>(Role.class),l);
    }
}
