package com.qubaichen.ssh.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qubaichen.ssh.dao.IUserDao;
import com.qubaichen.ssh.dao.UserDAO;
import com.qubaichen.ssh.model.User;

public class LoginService implements ILoginService {
	//初始化日志类对象，以便下边使用。
	private static final Logger log = LoggerFactory
			.getLogger(LoginService.class);
	
	private IUserDao loginDao;
	public IUserDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(IUserDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override
	public User getUserInfo(String username, String password) {
		// TODO Auto-generated method stub
		User testuser= new User(username,password);
		List<?> list = this.loginDao.findByExample(testuser);
		if(list.size()>0)  return (User)list.get(0);
		else return null;
	}
	
	@Override
	public void add(User user){
		try{
			log.info("Action saving User instance:"+user.getUsername()+","+user.getPassword());
			this.loginDao.save(user);
			log.info("Action save successfully:"+user.getUsername()+","+user.getPassword());
		} catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public List findAll() {  
        return this.loginDao.findAll();  
	}

	public void delete(Integer id) {  
		User testuser= this.loginDao.findById(id);
        this.loginDao.delete(testuser);  
} 
	public void update(User user) {  
        this.loginDao.update(user);  
}
	public User findById(Integer id){
		return 	  this.loginDao.findById(id);  
	}


}

