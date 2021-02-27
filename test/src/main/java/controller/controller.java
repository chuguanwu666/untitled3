package controller;

import domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.RoleService;
import org.springframework.stereotype.Controller;

@RequestMapping("/role")
@Controller
public class controller {
    @Autowired
    private RoleService roleService;
    @RequestMapping("/save")
public String save(Role role){
         roleService.Save(role);

        return "redirect:findAll";
}

@RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
   
        mv.addObject("list",roleService.findAll());
        mv.setViewName("role-list");
        return mv;
    }
}
