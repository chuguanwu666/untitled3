package com.qubaichen.ssh.dao;

import java.util.List;

import com.qubaichen.ssh.model.User;

public interface IUserDao {


	public static final String ID = "id";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";

	public abstract void save(User transientInstance);

	public abstract User findById(Integer id);

	public abstract List findByExample(User instance); //����User�����ѯ

	public abstract List findByUsername(Object username); //username�����ֶβ�ѯ

	public abstract List findAll();
	
	public abstract void delete(User persistentInstance);
	
	public abstract void update(User Instance);
}

