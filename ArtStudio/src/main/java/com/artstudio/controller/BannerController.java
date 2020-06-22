package com.artstudio.controller;

import com.artstudio.dao.pojo.Banner;
import com.artstudio.dao.pojo.Role;
import com.artstudio.service.BannerService;
import com.artstudio.service.RoleService;
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
 * @date: 2020/06/20/10:58 上午
 * @description:
 */
@Controller
@RequestMapping("/banner")
public class BannerController {
    private static final Logger logger = LogManager.getLogger(BannerController.class);

    @Autowired(required = false)
    private BannerService bannerService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectBanner(Banner banner){
        logger.info("select Banner is :" + banner);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Banner> list = bannerService.findAllService();
            resultMap.put("code",200);
            resultMap.put("msg","查询成功");
            resultMap.put("data",list);
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","查询失败");
            e.printStackTrace();
            logger.error("select Banner error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addBanner(Banner banner){
        logger.info("add Banner is :" + banner);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            long createAt = DateUtil.timestamp();
            banner.setCreateAt(createAt);
            bannerService.insertSelectiveService(banner);
            resultMap.put("code",200);
            resultMap.put("msg","添加成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add Banner error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> delBanner(@PathVariable Long id){

        logger.info("del Banner's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(bannerService.selectByPrimaryKeyService(id)==null){
                resultMap.put("code", 404);
                resultMap.put("msg", "该Banner不存在！");
            }else {
                bannerService.deleteByPrimaryKeyService(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("del Banner error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/mod/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> modBanner(@PathVariable Long id, Banner banner){

        logger.info("mod Role's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(bannerService.selectByPrimaryKeyService(id)==null){
                resultMap.put("code", 404);
                resultMap.put("msg", "该Banner不存在！");
            }else {
                long updateAt = DateUtil.timestamp();
                banner.setUpdateAt(updateAt);
                bannerService.updateByPrimaryKeySelectiveService(banner);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("mod Banner error");
        }
        return resultMap;
    }

}
