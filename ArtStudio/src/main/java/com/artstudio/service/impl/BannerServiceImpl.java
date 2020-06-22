package com.artstudio.service.impl;

import com.artstudio.dao.mapper.BannerMapper;
import com.artstudio.dao.pojo.Banner;
import com.artstudio.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: WangPeng
 * @date: 2020/06/19/5:34 下午
 * @description:
 */
@Service("bannerService")
public class BannerServiceImpl implements BannerService {
    @Autowired(required = false)
    BannerMapper bannerMapper;
    @Override
    public int deleteByPrimaryKeyService(Long id) {
        return bannerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertService(Banner banner) {
        return bannerMapper.insert(banner);
    }

    @Override
    public int insertSelectiveService(Banner banner) {
        return bannerMapper.insertSelective(banner);
    }

    @Override
    public Banner selectByPrimaryKeyService(Long id) {
        return bannerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelectiveService(Banner banner) {
        return bannerMapper.updateByPrimaryKeySelective(banner);
    }

    @Override
    public int updateByPrimaryKeyService(Banner banner) {
        return bannerMapper.updateByPrimaryKey(banner);
    }

    @Override
    public List<Banner> findAllService() {
        return bannerMapper.findAll();
    }
}
