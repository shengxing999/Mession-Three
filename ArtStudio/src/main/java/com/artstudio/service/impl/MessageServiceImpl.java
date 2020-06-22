package com.artstudio.service.impl;

import com.artstudio.dao.mapper.MessageMapper;
import com.artstudio.dao.pojo.Message;
import com.artstudio.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:35 下午
 * @description:
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Autowired(required = false)
    MessageMapper messageMapper;
    @Override
    public int deleteByPrimaryKeyService(Long id) {
        return messageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertService(Message message) {
        return messageMapper.insert(message);
    }

    @Override
    public int insertSelectiveService(Message message) {
        return messageMapper.insertSelective(message);
    }

    @Override
    public Message selectByPrimaryKeyService(Long id) {
        return messageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelectiveService(Message message) {
        return messageMapper.updateByPrimaryKeySelective(message);
    }

    @Override
    public int updateByPrimaryKeyService(Message message) {
        return messageMapper.updateByPrimaryKey(message);
    }

    @Override
    public List<Message> findAllService() {
        return messageMapper.findAll();
    }
}
