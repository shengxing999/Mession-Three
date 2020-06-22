package com.artstudio.controller;

import com.artstudio.dao.pojo.Role;
import com.artstudio.dao.pojo.StudioDetails;
import com.artstudio.service.RoleService;
import com.artstudio.service.StudioDetailsService;
import com.artstudio.service.UserService;
import com.artstudio.utils.DateUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/20/10:59 上午
 * @description:
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    private static final Logger logger = LogManager.getLogger(RoleController.class);

    @Autowired(required = false)
    private RoleService roleService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectRole(Role role){
        logger.info("select Role is :" + role);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Role> list = roleService.findAllService();
            resultMap.put("code",200);
            resultMap.put("msg","查询成功");
            resultMap.put("data",list);
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","查询失败");
            e.printStackTrace();
            logger.error("select Role error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addRole(Role role){
        logger.info("add Role is :" + role);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            long createAt = DateUtil.timestamp();
            role.setCreateAt(createAt);
            roleService.insertSelectiveService(role);
            resultMap.put("code",200);
            resultMap.put("msg","添加成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add Role error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> delRole(@PathVariable Long id){

        logger.info("del Role's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(roleService.selectByPrimaryKeyService(id)==null){
                resultMap.put("code", 404);
                resultMap.put("msg", "该Role不存在！");
            }else {
                roleService.deleteByPrimaryKeyService(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("del Role error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/mod/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> modRole(@PathVariable Long id, Role role){

        logger.info("mod Role's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(roleService.selectByPrimaryKeyService(id)==null){
                resultMap.put("code", 404);
                resultMap.put("msg", "该Role不存在！");
            }else {
                long updateAt = DateUtil.timestamp();
                role.setUpdateAt(updateAt);
                roleService.updateByPrimaryKeySelectiveService(role);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("mod Role error");
        }
        return resultMap;
    }

}
