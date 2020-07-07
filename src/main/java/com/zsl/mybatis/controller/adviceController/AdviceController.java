package com.zsl.mybatis.controller.adviceController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : zsl
 * @date : Created in 2020/6/26 5:21 下午
 */
@Slf4j
@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler({RuntimeException.class})
    public String runtimeExceptionHandler(RuntimeException e) {
        log.info("运行时异常");
        return e.getMessage();
    }

    /**
     * 单个参数校验异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public List<String> constraintViolationException(ConstraintViolationException e) {
        log.error("单个参数校验异常");
        List<String> defaultMsg = e.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
        return  defaultMsg;
    }

    /**
     *实体参数校验
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> methodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        // 获取所有字段参数不匹配的参数集合
        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        Map<String, Object> result = new HashMap<>(fieldErrorList.size());
        fieldErrorList.forEach(error -> {
            // 将错误参数名称和参数错误原因存于map集合中
            result.put(error.getField(), error.getDefaultMessage());
        });
        log.info("========参数校验异常=========");
        return result;
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(BindException.class)
    public Map<String, Object> bindExceptionHandler(BindException e) {
        // 获取所有字段参数不匹配的参数集合
        List<FieldError> fieldErrorList = e.getFieldErrors();
        Map<String, Object> result = new HashMap<>(fieldErrorList.size());
        fieldErrorList.forEach(error -> {
            // 将错误参数名称和参数错误原因存于map集合中
            result.put(error.getField(), error.getDefaultMessage());
        });
        log.info("========参数校验异常=========");
        return result;
    }

}
