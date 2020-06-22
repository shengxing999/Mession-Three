package com.artstudio.service;

import com.artstudio.dao.pojo.Banner;
import com.artstudio.dao.pojo.StudioDetails;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:20 下午
 * @description:
 */
public interface StudioDetailsService {
    int deleteByPrimaryKeyService(Long id);

    int insertService(StudioDetails studioDetails);

    int insertSelectiveService(StudioDetails studioDetails);

    StudioDetails selectByPrimaryKeyService(Long id);

    int updateByPrimaryKeySelectiveService(StudioDetails studioDetails);

    int updateByPrimaryKeyService(StudioDetails studioDetails);

    List<StudioDetails> findAllService();
}
