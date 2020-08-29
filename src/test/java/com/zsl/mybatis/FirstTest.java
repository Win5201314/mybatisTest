package com.zsl.mybatis;

import com.zsl.mybatis.entity.Websites;
import com.zsl.mybatis.service.WebsitesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : zsl
 * @date : Created in 2020/6/25 11:33 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstTest {

    @Autowired
    WebsitesService websitesService;

    @Test
    public void test1() {
        Websites websites = new Websites(null, "zsl", "http://www.baidu.com", 152, "CN");
        boolean flag = websitesService.saveWebsites(websites);
        if (flag) {
            System.out.println(websites);
        } else {
            System.out.println("保存失败");
        }
    }

}
