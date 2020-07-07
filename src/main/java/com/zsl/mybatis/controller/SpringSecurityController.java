package com.zsl.mybatis.controller;

//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zsl
 * @date : Created in 2020/6/26 5:19 下午
 * 参考博客：https://blog.csdn.net/u014553029/article/details/86690622 集中式且前后端未分离
 */
@RestController
public class SpringSecurityController {

    //@Secured({"ROLE_ADMIN"})
    @GetMapping("/security")
    public String security() {
        return "hello,security";
    }
}
