package controller;

import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.AccountService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account) throws IOException {
        ApplicationContext x=new ClassPathXmlApplicationContext();
        accountService.save(account);
        return "保存成功";
    }
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws IOException {
        List<Account> all = accountService.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("list",all);
        mv.setViewName("list");
        return mv;


    }

}
