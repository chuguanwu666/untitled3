package com.qubaichen.ssh.service;
import java.util.List;

import com.qubaichen.ssh.model.User;

public interface ILoginService {

	public User getUserInfo(String user, String password) ;
	
	public void add(User user);
	public List findAll();
	public void delete(Integer id);
	public void update(User user);
	public User findById(Integer id);
}

