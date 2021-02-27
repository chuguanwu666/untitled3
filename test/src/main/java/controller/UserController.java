package controller;

import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
  UserService userService;
  @Autowired

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){

     ModelAndView modelAndView=new ModelAndView();
        System.out.println(userService.findAll());
     modelAndView.addObject("list",userService.findAll());
     modelAndView.setViewName("user-list");
     return modelAndView;
    }
    @RequestMapping("saveUI")
    public ModelAndView saveUI(){
      ModelAndView mv=new ModelAndView();
      mv.setViewName("user-add");
      mv.addObject("list",userService.saveUI());
      return mv;
    }
    @RequestMapping("/save")
    public String save(User user,Long []roleIds){

       userService.saveUser(user,roleIds);
       return "redirect:findAll";
    }
    @RequestMapping("/del/{id}")
    public String del(@PathVariable("id") Long userId){
 userService.del(userId);
        return "redirect:/user/findAll";
    }
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){


        User login = userService.login(username, password);
        if (login!=null){
            session.setAttribute("user",login);
            return "redirect:/index.jsp";
        }
        else{

            return "redirect:/login.jsp";
        }


    }
}
