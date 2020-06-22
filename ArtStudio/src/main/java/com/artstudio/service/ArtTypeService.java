package com.artstudio.service;

import com.artstudio.dao.pojo.ArtType;
import com.artstudio.dao.pojo.Module;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:10 下午
 * @description:
 */
public interface ArtTypeService {
    int deleteByPrimaryKeyService(Long id);

    int insertService(ArtType artType);

    int insertSelectiveService(ArtType artType);

    ArtType selectByPrimaryKeyService(Long id);

    int updateByPrimaryKeySelectiveService(ArtType artType);

    int updateByPrimaryKeyService(ArtType artType);

    List<ArtType> findAllService();
}
