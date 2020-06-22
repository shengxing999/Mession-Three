package com.artstudio.controller;

import com.artstudio.dao.pojo.Banner;
import com.artstudio.dao.pojo.Message;
import com.artstudio.service.BannerService;
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
 * @date: 2020/06/20/10:58 上午
 * @description:
 */
@Controller
@RequestMapping("/message")
public class MessageController {
    private static final Logger logger = LogManager.getLogger(MessageController.class);

    @Autowired(required = false)
    private MessageService messageService;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectMessage(Message message){
        logger.info("select Message is :" + message);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<Message> list = messageService.findAllService();
            resultMap.put("code",200);
            resultMap.put("msg","查询成功");
            resultMap.put("data",list);
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","查询失败");
            e.printStackTrace();
            logger.error("select Message error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addMessage(Message message){
        logger.info("add Message is :" + message);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            long createAt = DateUtil.timestamp();
            message.setCreateAt(createAt);
            messageService.insertSelectiveService(message);
            resultMap.put("code",200);
            resultMap.put("msg","添加成功");
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","添加失败");
            e.printStackTrace();
            logger.error("add Message error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> delMessage(@PathVariable Long id){

        logger.info("del Message's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(messageService.selectByPrimaryKeyService(id)==null){
                resultMap.put("code", 404);
                resultMap.put("msg", "该Message不存在！");
            }else {
                messageService.deleteByPrimaryKeyService(id);
                resultMap.put("code", 200);
                resultMap.put("msg", "删除成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","删除失败");
            e.printStackTrace();
            logger.error("del Message error");
        }
        return resultMap;
    }
    @RequestMapping(value = "/mod/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> modMessage(@PathVariable Long id, Message message){

        logger.info("mod Message's id is :" + id);
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(messageService.selectByPrimaryKeyService(id)==null){
                resultMap.put("code", 404);
                resultMap.put("msg", "该Message不存在！");
            }else {
                long updateAt = DateUtil.timestamp();
                message.setUpdateAt(updateAt);
                messageService.updateByPrimaryKeySelectiveService(message);
                resultMap.put("code", 200);
                resultMap.put("msg", "修改成功");
            }
        }catch (Exception e){
            resultMap.put("code",404);
            resultMap.put("msg","修改失败");
            e.printStackTrace();
            logger.error("mod Message error");
        }
        return resultMap;
    }
}
