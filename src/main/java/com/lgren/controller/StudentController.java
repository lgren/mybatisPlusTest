package com.lgren.controller;


import com.github.jsonzou.jmockdata.JMockData;
import com.lgren.entity.Student;
import com.lgren.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Lgren
 * @since 2018-11-02
 */
@Api(tags="Student模块")
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String toIndex(Map<String, Object> map) {
        map.put("thisIsStudent", new Student().setId(1058278641265278978L).selectById());
        return "studentJSP";
    }

    @ApiOperation(value = "查看所有学生",httpMethod="GET")
    @ResponseBody
    @GetMapping("selectAllStudent")
    public List<Student> selectAllStudent() {
//        List<Student> studentList = studentService.list(new LambdaQueryWrapper<Student>()
//                .like(Student::getUsername, "邂逅")
//                .gt(Student::getBirthday, LocalDateTime.of(2099, 1, 1, 0, 0)));
        List<Student> studentList = studentService.selectAllStudent();
        return studentList;
    }

    @ApiOperation(value = "添加学生",httpMethod="POST")
    @ResponseBody
    @PostMapping("insertStudent")
    public boolean insertStudent() {
        return JMockData.mock(Student.class).insert();
    }
}
