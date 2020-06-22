package com.artstudio.controller;

import com.artstudio.dao.pojo.User;
import com.artstudio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/16/7:05 下午
 * @description:
 */
@Controller
public class LoginController {
    @Autowired(required = false)
    private UserService userService;

    @RequestMapping(value = "/logView")
    public String loginView() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, HttpSession session, Model model) {
        User logUser = userService.loginService(user);
        if (logUser != null) {
            session.setAttribute("logUser", user);
            return "main";
        }
        else{
            model.addAttribute("message","用户名不存在或密码错误，请重新登录。");
        }
        return "login";
    }
}
