package com.artstudio.service;

import com.artstudio.dao.pojo.Banner;
import com.artstudio.dao.pojo.Module;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:21 下午
 * @description:
 */
public interface BannerService {
    int deleteByPrimaryKeyService(Long id);

    int insertService(Banner banner);

    int insertSelectiveService(Banner banner);

    Banner selectByPrimaryKeyService(Long id);

    int updateByPrimaryKeySelectiveService(Banner banner);

    int updateByPrimaryKeyService(Banner banner);

    List<Banner> findAllService();
}
