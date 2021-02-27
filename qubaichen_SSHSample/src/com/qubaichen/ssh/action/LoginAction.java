package com.qubaichen.ssh.action;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import com.qubaichen.ssh.service.ILoginService;
import com.qubaichen.ssh.dao.UserDAO;
import com.qubaichen.ssh.model.User;

/* 
 * 本实验中Action使用模型驱动，ModelDriven<User>
 */
public class LoginAction extends ActionSupport implements ModelDriven<User> {
	//初始化日志类对象，以便下边使用。
	private static final Logger log = LoggerFactory
			.getLogger(LoginAction.class);
	
	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	private ILoginService loginService;
			
	public ILoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	//Action登录用函数getLogin()
	public String getLogin(){
		log.info("User loging:"+user.getUsername()+","+user.getPassword());
		User  testuser =this.loginService.getUserInfo(user.getUsername(),user.getPassword());
		if( testuser != null){
			log.info("user login successful："+user.getUsername()+","+user.getPassword());
			return SUCCESS;
		}
		else{
			log.info("user login error ："+user.getUsername()+","+user.getPassword());
			
			HttpServletRequest request = ServletActionContext.getRequest();	
			request.setAttribute("message", "您的的用户或密码错误，请重新登录！");
			return INPUT;
		}	
	}
	
	//Action添加用函数register()
	public String register(){
		log.debug("Servie add User instance:"+user.getUsername()+","+user.getPassword());
		this.loginService.add(user);
		log.debug("Servie save successful:"+user.getUsername()+","+user.getPassword()+"Add successfully!");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", "您的的用户注册成功，请重新登录！");
		return INPUT;
	
	}
	
	public String getAllList() throws Exception {
		List returnAll = this.loginService.findAll();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list",returnAll);
        return SUCCESS;
	}

	public String doDelete() throws Exception {
		this.loginService.delete(new Integer(user.getId()));
		System.out.println(user.getId()+"Delete Success");
		return SUCCESS;
	}
	
	public String doEditInput() {
		user= this.loginService.findById(user.getId());
		ActionContext.getContext().getValueStack().push(user);
		return "success";
	}
	
	public String doEditSubmit() throws Exception {
		if (user.getUsername().trim().equals("")) {
			 return "input";
		} else {		
			this.loginService.update(user);
			System.out.println(user.getUsername()+user.getPassword()+"udpate Success");
		}
		return "search";
	}



}


