package com.zsl.mybatis.service.impl;

import com.zsl.mybatis.dao.WebsitesMapper;
import com.zsl.mybatis.entity.Websites;
import com.zsl.mybatis.service.WebsitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author : zsl
 * @date : Created in 2020/6/25 9:56 上午
 */
@Service
public class WebsitesServiceImpl implements WebsitesService {

    @Autowired
    WebsitesMapper websitesMapper;

    @Override
    public boolean saveWebsites(Websites websites) {
        return websitesMapper.saveWebsites(websites);
    }

    @Override
    public boolean deleteWebsites(Integer id) {
        return websitesMapper.deleteWebsites(id);
    }

    @Override
    public boolean updateWebsites(Websites websites) {
        return websitesMapper.updateWebsites(websites);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateWebsitesByAlexa(Integer id, Integer alexa) {
        return websitesMapper.updateWebsitesByAlexa(id, alexa);
    }

    @Override
    public Websites selectWebsitesById(Integer id) {
        return websitesMapper.selectWebsitesById(id);
    }

    @Override
    public List<Websites> selectWebsitesByCountry(String country) {
        return websitesMapper.selectWebsitesByCountry(country);
    }

    @Override
    public Websites selectWebsitesByIdMap(HashMap<String, Object> map) {
        return websitesMapper.selectWebsitesByIdMap(map);
    }

    @Override
    public List<Websites> selectWebsitesByIdMapList(HashMap<String, Object> map) {
        return websitesMapper.selectWebsitesByIdMapList(map);
    }
}
