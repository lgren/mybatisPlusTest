package com.lgren.controller;


import com.fasterxml.jackson.core.JsonGenerator;
import com.github.jsonzou.jmockdata.JMockData;
import com.lgren.entity.Student;
import com.lgren.service.IStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 * @author Lgren
 * @since 2018-11-02
 */
@Api(tags = "Student")
@Controller
@RequestMapping("/student")
public class StudentController {
    private static final Logger logger = Logger.getLogger(StudentController.class);


    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public String toIndex(Map<String, Object> map) {
        map.put("thisIsStudent", new Student().setId(1058278641265278978L).selectById());
        return "studentJSP";
    }

    @ApiOperation(value = "查看所有学生",notes = "查看所有学生Notes", httpMethod = "GET")
    @ResponseBody
    @GetMapping("selectAllStudent")
    public List<Student> selectAllStudent() {
        //        List<Student> studentList = studentService.list(new LambdaQueryWrapper<Student>()
        //                .like(Student::getUsername, "邂逅")
        //                .gt(Student::getBirthday, LocalDateTime.of(2099, 1, 1, 0, 0)));
        List<Student> studentList = studentService.selectAllStudent();
        return studentList;
    }

    @ApiOperation(value = "添加学生", httpMethod = "POST")
    @ResponseBody
    @PostMapping("insertStudent")
    public boolean insertStudent() {
        Student studentVar = JMockData.mock(Student.class);
        logger.info(studentVar.toString());
        logger.error(studentVar.toString());
        return studentVar.insert();
    }

    @ApiOperation(value = "添加学生带名字的", httpMethod = "POST")
    @ApiImplicitParam(name = "name", value = "学生名字", required = true, dataType = "String")
    @ResponseBody
    @PostMapping("insertStudentWithName")
    public boolean insertStudentWithName(String name) {
        Student studentVar = JMockData.mock(Student.class);
        studentVar.setRealName(name);
        logger.info(studentVar.toString());
        logger.error(studentVar.toString());
        return studentVar.insert();
    }
}
