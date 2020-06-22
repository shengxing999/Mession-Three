package com.artstudio.dao.mapper;

import com.artstudio.dao.pojo.Message;
import com.artstudio.dao.pojo.Module;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Message message);

    int insertSelective(Message message);

    Message selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Message message);

    int updateByPrimaryKey(Message message);

    List<Message> findAll();

}