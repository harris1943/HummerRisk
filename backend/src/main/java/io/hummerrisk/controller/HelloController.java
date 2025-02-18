package io.hummerrisk.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

@ApiIgnore
@RestController
@RequestMapping("anonymous")
public class HelloController {
    @Resource
    MessageSource messageSource;

    @GetMapping("hello")
    public String hello() {
        return messageSource.getMessage("max_thread_insufficient", null, "默认值", LocaleContextHolder.getLocale());
    }
}
