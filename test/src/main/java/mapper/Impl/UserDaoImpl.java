package mapper.Impl;

import mapper.UserDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User login(String username, String password) throws DataAccessException {
        return jdbcTemplate.queryForObject("select *from sys_user where username=? and password=?",new BeanPropertyRowMapper<User>(User.class),username,password);
    }

    JdbcTemplate jdbcTemplate=new JdbcTemplate();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select *from  sys_user",new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public void del(Long userId) {
//        先删除从表

        jdbcTemplate.update("delete from sys_user_role where userId=?",userId);
        jdbcTemplate.update("delete from sys_user where id=?",userId);
    }

    public Long saveUser(final User user){

        PreparedStatementCreator ps=new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement statement = connection.prepareStatement("insert into sys_user values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setString(1,null);
                statement.setString(2,user.getUsername());
                statement.setString(3,user.getEmail());
                statement.setString(4,user.getPassword());
                statement.setString(5,user.getPhoneNum());
                return statement;
            }
        };
        GeneratedKeyHolder c=new GeneratedKeyHolder();
        jdbcTemplate.update(ps,c);
        Long key = c.getKey().longValue();
        return key;

    }
    public void save(Long userId,Long roleId){
        jdbcTemplate.update("insert into sys_user_role values (?,?)",userId,roleId);

    }
}
