package com.artstudio.controller;

import com.artstudio.dao.pojo.Module;
import com.artstudio.dao.pojo.StudioDetails;
import com.artstudio.service.ModuleService;
import com.artstudio.service.StudioDetailsService;
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
 * @date: 2020/06/20/8:20 下午
 * @description:
 */
@Controller
@RequestMapping("/studio")
public class StudioDetailsController {
    private static final Logger logger = LogManager.getLogger(StudioDetailsController.class);

    @Autowired(required = false)
    private StudioDetailsService studioDetailsService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectStudioDetails(StudioDetails studioDetails){
        logger.info("select StudioDetails is :" + studioDetails);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<StudioDetails> list = studioDetailsService.findAllService();
            resultMap.put("code",200);
            resultMap.put("msg","查询成功");
            resultMap.put("data",list);
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","查询失败");
            e.printStackTrace();
            logger.error("select StudioDetails error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addStudioDetails(StudioDetails studioDetails){
        logger.info("add StudioDetails is :" + studioDetails);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            long createAt = DateUtil.timestamp();
            studioDetails.setCreateAt(createAt);
            studioDetailsService.insertSelectiveService(studioDetails);
            resultMap.put("code",200);
            resultMap.put("msg","添加成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add StudioDetails error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> delStudioDetails(@PathVariable Long id,StudioDetails studioDetails){

        logger.info("del StudioDetails's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(studioDetailsService.selectByPrimaryKeyService(id)==null){
                resultMap.put("code", 404);
                resultMap.put("msg", "该StudioDetails不存在！");
            }else {
                studioDetailsService.deleteByPrimaryKeyService(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("del StudioDetails error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/mod/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> modStudioDetails(@PathVariable Long id, StudioDetails studioDetails){

        logger.info("mod StudioDetails's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(studioDetailsService.selectByPrimaryKeyService(id)==null){
                resultMap.put("code", 404);
                resultMap.put("msg", "该StudioDetails不存在！");
            }else {
                long updateAt = DateUtil.timestamp();
                studioDetails.setUpdateAt(updateAt);
                studioDetailsService.updateByPrimaryKeySelectiveService(studioDetails);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("mod StudioDetails error");
        }
        return resultMap;
    }
}
