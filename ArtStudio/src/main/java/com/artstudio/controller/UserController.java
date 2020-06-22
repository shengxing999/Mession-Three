package com.artstudio.controller;

import com.artstudio.dao.pojo.User;
import com.artstudio.service.UserService;
import com.artstudio.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/17/4:05 下午
 * @description:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    @RequestMapping(value = "/addView", method = RequestMethod.GET)
    public ModelAndView addUserView(Model model) {
        new LocalValidatorFactoryBean();
        model.addAttribute("user", new User());
        return new ModelAndView("userInsert", "", model);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult bindingResult, Model model) throws Exception {

        if (bindingResult.hasErrors()) {
            FieldError fe = bindingResult.getFieldError();
            return "userInsert";
        }
        long roleId = 1L;
        long createAt = DateUtil.timestamp();
        long createBy = 1L;
        user.setRoleId(roleId);
        user.setCreateAt(createAt);
        user.setCreateBy(createBy);
        boolean check = userService.checkService(user.getUsername());
        if (check) {
            model.addAttribute("message","用户名已被使用，请更换用户名");
            return "userInsert";
        } else {
            userService.addUserService(user);
        }
        return "userShow";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteById(int id) throws Exception {
        userService.deleteUserService(id);
        return "userShow";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, Model model) throws Exception {
        model.addAttribute("user", userService.selectUserByIdService(id));
        return "userUpdate";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(User user) throws Exception {
        userService.updateUserService(user);
        return "userShow";
    }

    @RequestMapping(value ="/show",method=RequestMethod.GET)
    public String userList(@RequestParam(required=true,defaultValue="1") Integer page,Model model){
        //page默认值是1，pageSize默认是10，意思是从第1页开始，每页显示10条记录。
        PageHelper.startPage(page, 10);
        List<User> userList = userService.findAllUserService();
        System.out.println(userList);
        PageInfo<User> p=new PageInfo<User>(userList);
        model.addAttribute("page", p);
        model.addAttribute("userList",userList);
        return "userShow";
    }

}
