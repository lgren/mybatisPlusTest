package com.lgren.swagger2;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger
 * @author Lgren
 * @create 2018-11-02 16:55
 **/
@EnableWebMvc
@EnableSwagger2
@Component
public class ApiConfig {}
// http://localhost:8080/swagger-ui.html