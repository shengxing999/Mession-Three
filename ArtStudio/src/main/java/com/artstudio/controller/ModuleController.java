package com.artstudio.controller;

import com.artstudio.dao.pojo.Module;
import com.artstudio.service.ModuleService;
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
 * @date: 2020/06/20/3:04 下午
 * @description:
 */
@Controller
@RequestMapping("/module")
public class ModuleController {
    private static final Logger logger = LogManager.getLogger(ModuleController.class);

    @Autowired(required = false)
    private ModuleService moduleService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectModule(Module module) {
        logger.info("select Module is :" + module);
        Map<String, Object> resultMap = new HashMap<>();
        try {
            List<Module> list = moduleService.findAllService();
            resultMap.put("code", 200);
            resultMap.put("msg", "查询成功");
            resultMap.put("data", list);
        } catch (Exception e) {
            resultMap.put("code", 404);
            resultMap.put("msg", "查询失败");
            e.printStackTrace();
            logger.error("select Module error");
        }
        return resultMap;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addModule(Module module) {
        logger.info("add Module is :" + module);
        Map<String, Object> resultMap = new HashMap<>();
        try {
            long createAt = DateUtil.timestamp();
            module.setCreateAt(createAt);
            moduleService.insertSelectiveService(module);
            resultMap.put("code", 200);
            resultMap.put("msg", "添加成功");
        } catch (Exception e) {
            resultMap.put("code", 404);
            resultMap.put("msg", "添加失败");
            e.printStackTrace();
            logger.error("add Module error");
        }
        return resultMap;
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> delModule(@PathVariable Long id, Module module) {

        logger.info("del Module's id is :" + id);
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if (moduleService.selectByPrimaryKeyService(id) == null) {
                resultMap.put("code", 404);
                resultMap.put("msg", "该module不存在！");
            } else {
                moduleService.deleteByPrimaryKeyService(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        } catch (Exception e) {
            resultMap.put("code", 404);
            resultMap.put("msg", "删除失败");
            e.printStackTrace();
            logger.error("del Module error");
        }
        return resultMap;
    }

    @RequestMapping(value = "/mod/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> modModule(@PathVariable Long id, Module module) {

        logger.info("mod Module's id is :" + id);
        Map<String, Object> resultMap = new HashMap<>();
        try {
            if (moduleService.selectByPrimaryKeyService(id) == null) {
                resultMap.put("code", 404);
                resultMap.put("msg", "该module不存在！");
            } else {
                moduleService.updateByPrimaryKeySelectiveService(module);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        } catch (Exception e) {
            resultMap.put("code", 404);
            resultMap.put("msg", "修改失败");
            e.printStackTrace();
            logger.error("mod Module error");
        }
        return resultMap;
    }
}
