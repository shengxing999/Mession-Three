package com.artstudio.dao.mapper;

import com.artstudio.dao.pojo.Banner;
import com.artstudio.dao.pojo.Module;

import java.util.List;

public interface BannerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Banner banner);

    int insertSelective(Banner banner);

    Banner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Banner banner);

    int updateByPrimaryKey(Banner banner);

    List<Banner> findAll();

}