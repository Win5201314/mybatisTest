package com.zsl.mybatis.service;

import com.github.pagehelper.PageHelper;
import com.zsl.mybatis.MybatisApplication;
import com.zsl.mybatis.entity.Websites;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : zsl
 * @date : Created in 2020/6/25 4:03 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
@Slf4j
public class WebsitesServiceTest {

    @Autowired
    WebsitesService websitesService;

    @Test
    @Transactional
    public void saveWebsites() {
    }

    @Test
    public void deleteWebsites() {
    }

    @Test
    public void updateWebsites() {
    }

    @Test
    public void updateWebsitesByAlexa() {
    }

    @Test
    @Transactional
    public void selectWebsitesById() {
        Websites websites = websitesService.selectWebsitesById(1);
        log.info(websites.toString());
        System.out.println("======================");
        websites = websitesService.selectWebsitesById(1);
        log.info(websites.toString());
    }

    @Test
    @Transactional
    public void selectWebsitesByCountry() {
        PageHelper.startPage(1, 3);
        List<Websites> list = websitesService.selectWebsitesByCountry("CN");
        for (Websites websites : list) {
            System.out.println(websites);
        }
    }

    @Test
    public void selectWebsitesByIdMap() {
    }

    @Test
    public void selectWebsitesByIdMapList() {
    }
}