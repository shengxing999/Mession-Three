package com.artstudio.controller;

import com.artstudio.dao.pojo.Art;
import com.artstudio.dao.pojo.StudioDetails;
import com.artstudio.service.ArtService;
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
 * @date: 2020/06/20/10:57 上午
 * @description:
 */
@Controller
@RequestMapping("/art")
public class ArtController {
    private static final Logger logger = LogManager.getLogger(ArtController.class);

    @Autowired(required = false)
    private ArtService artService;
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectArt(Art art){
        logger.info("select Art is :" + art);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Art> list = artService.findAllService();
            resultMap.put("code",200);
            resultMap.put("msg","查询成功");
            resultMap.put("data",list);
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","查询失败");
            e.printStackTrace();
            logger.error("select Art error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addArt(Art art){
        logger.info("add Art is :" + art);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            long createAt = DateUtil.timestamp();
            art.setCreateAt(createAt);
            artService.insertSelectiveService(art);
            resultMap.put("code",200);
            resultMap.put("msg","添加成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add Art error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> delArt(@PathVariable Long id,Art art){

        logger.info("del Art's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(artService.selectByPrimaryKeyService(id)==null){
                resultMap.put("code", 404);
                resultMap.put("msg", "该Art不存在！");
            }else {
                artService.deleteByPrimaryKeyService(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("del Art error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/mod/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> modArt(@PathVariable Long id, Art art){

        logger.info("mod Art's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(artService.selectByPrimaryKeyService(id)==null){
                resultMap.put("code", 404);
                resultMap.put("msg", "该Art不存在！");
            }else {
                long updateAt = DateUtil.timestamp();
                art.setUpdateAt(updateAt);
                artService.updateByPrimaryKeySelectiveService(art);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("mod Art error");
        }
        return resultMap;
    }
}
