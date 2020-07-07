package com.zsl.mybatis.controller;

import com.zsl.mybatis.entity.Websites;
import com.zsl.mybatis.service.WebsitesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : zsl
 * @date : Created in 2020/6/25 9:57 上午
 */
@RestController
@Slf4j
@Validated
public class WebsitesController {

    @Autowired
    WebsitesService websitesService;

    /**
     * http://localhost:8080/test
     */
    @GetMapping("/test")
    public String test() {
        return "hello,world!";
    }

    /**
     * 保存一个网址对象
     * http://localhost:8080/saveWebsites
     */
    @PostMapping("/saveWebsites")
    public String saveWebsites(@RequestBody @Valid Websites websites) {
        // 判断是否含有校验不匹配的参数错误
        /*if (bindingResult.hasErrors()) {
            // 获取所有字段参数不匹配的参数集合
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            Map<String, Object> result = new HashMap<>(fieldErrorList.size());
            fieldErrorList.forEach(error -> {
                // 将错误参数名称和参数错误原因存于map集合中
                result.put(error.getField(), error.getDefaultMessage());
            });
            log.info("============判断是否含有校验不匹配的参数错误==============");
            return result.toString();
        }*/
        log.info("======================是否执行");
        boolean flag = websitesService.saveWebsites(websites);
        if (flag) {
            log.info(websites.toString());
        } else {
            log.info("保存失败");
        }
        return "hello,world!" + flag;
    }

    /**
     * 删除一个网址记录 http://localhost:8080/deleteWebsites/
     * @param id 网址主键id
     * @return 是否删除成功
     */
    @GetMapping("/deleteWebsites/{id}")
    public String deleteWebsites(@PathVariable("id") Integer id) {
        String result = "";
        boolean flag = websitesService.deleteWebsites(id);
        if (flag) {
            result = "删除成功";
        } else {
            result = "删除失败";
        }
        return result;
    }

    /**
     * 修改一个网址记录
     * @param websites 网址新记录
     * @return 是否修改成功
     */
    @PostMapping("/updateWebsites")
    public String updateWebsites(@RequestBody Websites websites) {
        log.info(websites.toString());
        String result = "";
        boolean flag = websitesService.updateWebsites(websites);
        if (flag) {
            result = "更新成功";
        } else {
            result = "更新失败";
        }
        return result;
    }

    /**
     * 更新alexa字段根据主键 http://localhost:8080/updateWebsitesByAlexa
     * @param id 主键
     * @param alexa 排名
     * @return 是否更新成功
     */
    @PostMapping("/updateWebsitesByAlexa")
    public String updateWebsitesByAlexa(Integer id, Integer alexa) {
        String result = "";
        boolean flag = websitesService.updateWebsitesByAlexa(id, alexa);
        if (flag) {
            result = "更新成功";
        } else {
            result = "更新失败";
        }
        return  result;
    }

    /**
     * 根据主键查找一条网址记录
     * @param id 主键
     * @return 返回查找对象
     */
    @PostMapping("/selectWebsitesById")
    public Websites selectWebsitesById(Integer id) {
        return websitesService.selectWebsitesById(id);
    }

    /**
     * 根据国家查询
     * @param country 国家
     * @return 返回集合
     */
    @PostMapping("/selectWebsitesByCountry")
    public List<Websites> selectWebsitesByCountry(String country) {
        return websitesService.selectWebsitesByCountry(country);
    }
}
