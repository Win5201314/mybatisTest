package com.zsl.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;

/**
 * 参考博文：https://www.jianshu.com/p/60f21db245f1
 * 级联验证用
 * @Valid这个注解（一对一，一对多）
 * @author : zsl
 * @date : Created in 2020/6/22 3:35 下午
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Websites implements Serializable {

    private static final long serialVersionUID = 4162334049119728731L;

    @Null(message = "必须为空，数据库自己指定")
    private Integer id;
    @NotBlank
    @NotNull(message = "name不能为空")
    private String name;
    @NotNull(message = "url不能为空")
    private String url;
    @NotNull(message = "alexa不能为空")
    private Integer alexa;
    @NotNull(message = "country不能为空")
    private String country;
}
