package com.artstudio.service;

import com.artstudio.dao.pojo.Art;
import com.artstudio.dao.pojo.Module;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:01 下午
 * @description:
 */
public interface ArtService {
    int deleteByPrimaryKeyService(Long id);

    int insertService(Art art);

    int insertSelectiveService(Art art);

    Art selectByPrimaryKeyService(Long id);

    int updateByPrimaryKeySelectiveService(Art art);

    int updateByPrimaryKeyService(Art art);

    List<Art> findAllService();
}
