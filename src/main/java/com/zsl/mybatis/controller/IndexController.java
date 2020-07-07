package com.zsl.mybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author : zsl
 * @date : Created in 2020/6/28 10:32 下午
 */
@Slf4j
@RestController
@Validated
public class IndexController {

    @CrossOrigin
    @PostMapping("/index")
    public String index(@NotNull(message = "username不能为空") String username) {
        //String a = URLEncoder.encode(username);
        //a = URLDecoder.decode(username);

        log.info("==============" + username);
        return username;
    }

}
