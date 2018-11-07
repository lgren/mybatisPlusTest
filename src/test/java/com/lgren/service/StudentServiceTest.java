package com.lgren.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Sequence;
import com.baomidou.mybatisplus.core.toolkit.support.Property;
import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.MockConfig;
import com.lgren.entity.Student;
import com.lgren.entity.Teacher;
import com.lgren.util.LgrenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * StudentService测试类
 * @author Lgren
 * @create 2018-11-01 21:26
 **/
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class StudentServiceTest {
    @Autowired
    private IStudentService studentService;

    @Test
    public void generatingData() {
        //基本类型模拟
        int intNum = JMockData.mock(int.class);
        int[] intArray = JMockData.mock(int[].class);
        Integer integer = JMockData.mock(Integer.class);
        Integer[] integerArray = JMockData.mock(Integer[].class);
        //常用类型模拟
        BigDecimal bigDecimal = JMockData.mock(BigDecimal.class);
        BigInteger bigInteger = JMockData.mock(BigInteger.class);
        Date date = JMockData.mock(Date.class);
        String str = JMockData.mock(String.class);
        MockConfig mockConfig = new MockConfig().stringSeed(
                "浅唱","寂灭","无声","邂逅","流年","落寂",
                "墨年","磬音","浅唱","低吟","晨曦","邂逅",
                "叙述","唯爱","晨曦","回忆","错落","迷茫",
                "深音","铭记","迷遇","暖光","蘩藜","尘宵",
                "恬静","默诺","余音","情殇","背殇","落幕",
                "醉生","沉静","寂冷");
        Set<Student> stuAddList = ConcurrentHashMap.newKeySet(10_0000);
        int nThreads = 50;
        ExecutorService pool = Executors.newFixedThreadPool(nThreads);


//        AtomicReference<String> maxLengthStr = new AtomicReference<>("");
        AtomicInteger maxLength = new AtomicInteger(0);
        for (int i = 0; i < nThreads; i++) {
            pool.execute(() -> {
                for (int j = 0, size = 2000; j < size; j++) {
                    Student student = JMockData.mock(Student.class, mockConfig);
//                    Student student = new Student().setUsername("lgren3223" + UUID.randomUUID()).setPassword("lgren3223" + UUID.randomUUID());
                    stuAddList.add(student);
                    int strVar = LgrenUtil.calStrLength(student.toString());
                    if (strVar > maxLength.get()) {
                        maxLength.set(strVar);
                    }
                }
            });
        }
        pool.shutdown();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        List<Student> stuAddList = studentService.list(null);
//        studentService.remove(null);

        Long start = System.currentTimeMillis();
//        int maxLength = stuAddList.stream()
//                .mapToInt(o -> {
//                    o.setId(null);
//                    return LgrenUtil.calStrLength(o.toString());
//                }).min()
//                .orElseThrow(RuntimeException::new);
        studentService.insertBatchAutoCalLen(stuAddList, maxLength.get());
        Long userTime = System.currentTimeMillis() - start;
        System.out.println();
    }

    @Test
    public void studentServiceTest1() {
        // 初始化 User 对象
//        Student student = new Student();
//        studentService.selectStudentList(student);
//        // 插入 User (插入成功会自动回写主键到实体类)
//        student.setUsername("Tom");
//        System.out.println((studentService.insert(student) ? "success" : "fail") + " id:" + student.getId());
//
//        // 更新 User
//        student.setBirthday(new Date());
//        System.out.println((student.updateById() ? "success" : "fail") + " id:" + student.getId());
//        QueryWrapper<Student> wrapper = new QueryWrapper<>();
//        wrapper.eq("username", "lgren");
//        student.selectList(wrapper);
//
//        Student stuVar = new Student();
//        stuVar.setUsername("Lgren");
//        student.selectList(new QueryWrapper<>(stuVar));

        Sequence sequence = new Sequence();
        sequence.nextId();
//        List<Student> list1 = studentService.list(new QueryWrapper<Student>().like("username", "邂逅"));
        Property<Student, ?> realName = Student::getRealName;

        List<Student> list2 = studentService.list(new LambdaQueryWrapper<Student>()
                .like(realName, "lgren"));
        new Teacher().selectAll();
        JMockData.mock(Student.class);
        System.out.println();
    }

//    @Autowired
//    private ITaskMainService taskMainService;
//    @Test
//    public void studentServiceTest() {
////        Page<TaskMain> studentPage = taskMainService.selectPage(new Page<>(0, 10));
//        Set<String> studentIdPage = taskMainService.selectPage(new Page<>(0, 10)).getRecords().stream().map(TaskMain::getId).collect(Collectors.toSet());
//        System.out.println(studentIdPage);
//    }

}
