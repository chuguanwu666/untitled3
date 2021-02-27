package com.qubaichen.ssh.dao;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.qubaichen.ssh.model.User;

public class UserDAO extends HibernateDaoSupport implements IUserDao {
	//初始化日志类对象，以便下边使用。
	private static final Logger log = LoggerFactory
			.getLogger(UserDAO.class);
	


	@Override
	public void save(User transientInstance) {
		log.info("Dao saving User instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.info("Dao save successful");
		} catch (RuntimeException re) {
			log.error("Dao save failed", re);
			throw re;
		}
	}
	
	@Override
	public void delete(User persistentInstance) {
		log.info("Dao deleting User instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.info("Dao delete successful");
		} catch (RuntimeException re) {
			log.error("Dao delete failed", re);
			throw re;
		}
	}

	
	@Override
	public User findById(java.lang.Integer id) {
		log.info("Dao getting User instance with id: " + id);
		try {
			User instance = (User ) getHibernateTemplate().get(
					"com.qubaichen.ssh.model.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("Dao get failed", re);
			throw re;
		}
	}

	
	@Override
	public List findByExample(User instance) {
		log.debug("Dao finding User instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("Dao find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("Dao find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("Dao finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("Dao find by property name failed", re);
			throw re;
		}
	}

	
	@Override
	public List findByUsername(Object username) {
		return findByProperty(USERNAME , username);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	
	@Override
	public List findAll() {
		log.debug("Dao finding all User instances");
		try {
			String queryString = "from User";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("Dao find all failed", re);
			throw re;
		}
	}
	
	@Override
	public void update(User Instance) {
		// TODO Auto-generated method stub
		log.debug("saving Testuser instance");
		try {
			getHibernateTemplate().update(Instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		
	}

	public static IUserDao getFromApplicationContext(ApplicationContext ctx) {
		return (IUserDao) ctx.getBean("userDAO");
	}


}

