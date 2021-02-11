package service;

import domain.Account;
import mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@Service
public class AccountService {
    @Autowired
    private AccountMapper mapper;
    public void save(Account A) throws IOException {

        mapper.save(A);
    }
    public List<Account> findAll() throws IOException {

        List<Account> all = mapper.findAll();


        return all;
    }
}
