package com.cafe24.jblog2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.config.web.FileuploadConfig;
import com.cafe24.config.web.MVCConfig;
import com.cafe24.config.web.MessageConfig;
import com.cafe24.config.web.SecurityConfig;

@Configuration
//@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan({ "com.cafe24.jblog2.controller" })
@Import({ MVCConfig.class, MessageConfig.class, SecurityConfig.class, FileuploadConfig.class })
public class WebConfig {

}
