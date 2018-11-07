package com.lgren.controller;


import com.github.jsonzou.jmockdata.JMockData;
import com.lgren.entity.Teacher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lgren
 * @since 2018-11-02
 */
@Api(tags="Teacher模块")
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    
    @ApiOperation(value = "查看所有老师",httpMethod="GET")
    @GetMapping("selectAllTeacher")
    public List<Teacher> selectAllTeacher() {
        return new Teacher().selectAll();
    }

    @ApiOperation(value = "添加老师",httpMethod="POST")
    @ResponseBody
    @PostMapping("insertTeacher")
    public boolean insertTeacher() {
        return JMockData.mock(Teacher.class).insert();
    }
}
