package com.artstudio.controller;

import com.artstudio.dao.pojo.ArtType;
import com.artstudio.dao.pojo.Message;
import com.artstudio.service.ArtTypeService;
import com.artstudio.service.MessageService;
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
 * @date: 2020/06/22/9:14 上午
 * @description:
 */
@Controller
@RequestMapping("/artType")
public class ArtTypeController {
        private static final Logger logger = LogManager.getLogger(ArtTypeController.class);

        @Autowired(required = false)
        private ArtTypeService artTypeService;

        @RequestMapping(value = "/show", method = RequestMethod.GET)
        @ResponseBody
        public Map<String,Object> selectArtType(ArtType artType){
            logger.info("select ArtType is :" + artType);
            Map<String,Object> resultMap = new HashMap<>();
            try {
                List<ArtType> list = artTypeService.findAllService();
                resultMap.put("code",200);
                resultMap.put("msg","查询成功");
                resultMap.put("data",list);
            }catch (Exception e){
                resultMap.put("code",404);
                resultMap.put("msg","查询失败");
                e.printStackTrace();
                logger.error("select ArtType error");
            }
            return resultMap;
        }
        @RequestMapping(value = "/add", method = RequestMethod.POST)
        @ResponseBody
        public Map<String,Object> addArtType(ArtType artType){
            logger.info("add ArtType is :" + artType);
            Map<String,Object> resultMap = new HashMap<>();
            try {
                long createAt = DateUtil.timestamp();
                artType.setCreateAt(createAt);
                artTypeService.insertSelectiveService(artType);
                resultMap.put("code",200);
                resultMap.put("msg","添加成功");
            }catch (Exception e){
                resultMap.put("code",404);
                resultMap.put("msg","添加失败");
                e.printStackTrace();
                logger.error("add ArtType error");
            }
            return resultMap;
        }
        @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
        @ResponseBody
        public Map<String,Object> delArtType(@PathVariable Long id){

            logger.info("del ArtType's id is :" + id);
            Map<String,Object> resultMap = new HashMap<>();
            try {
                if(artTypeService.selectByPrimaryKeyService(id)==null){
                    resultMap.put("code", 404);
                    resultMap.put("msg", "该ArtType不存在！");
                }else {
                    artTypeService.deleteByPrimaryKeyService(id);
                    resultMap.put("code", 200);
                    resultMap.put("msg", "删除成功");
                }
            }catch (Exception e){
                resultMap.put("code",404);
                resultMap.put("msg","删除失败");
                e.printStackTrace();
                logger.error("del ArtType error");
            }
            return resultMap;
        }
        @RequestMapping(value = "/mod/{id}", method = RequestMethod.PUT)
        @ResponseBody
        public Map<String,Object> modArtType(@PathVariable Long id, ArtType artType){

            logger.info("mod ArtType's id is :" + id);
            Map<String,Object> resultMap = new HashMap<>();
            try {
                if(artTypeService.selectByPrimaryKeyService(id)==null){
                    resultMap.put("code", 404);
                    resultMap.put("msg", "该ArtType不存在！");
                }else {
                    long updateAt = DateUtil.timestamp();
                    artType.setUpdateAt(updateAt);
                    artTypeService.updateByPrimaryKeySelectiveService(artType);
                    resultMap.put("code", 200);
                    resultMap.put("msg", "修改成功");
                }
            }catch (Exception e){
                resultMap.put("code",404);
                resultMap.put("msg","修改失败");
                e.printStackTrace();
                logger.error("mod ArtType error");
            }
            return resultMap;
        }
}
