package com.artstudio.service;

import com.artstudio.dao.pojo.Banner;
import com.artstudio.dao.pojo.Message;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:15 下午
 * @description:
 */
public interface MessageService {

    int deleteByPrimaryKeyService(Long id);

    int insertService(Message message);

    int insertSelectiveService(Message message);

    Message selectByPrimaryKeyService(Long id);

    int updateByPrimaryKeySelectiveService(Message message);

    int updateByPrimaryKeyService(Message message);

    List<Message> findAllService();}
