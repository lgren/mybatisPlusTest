package com.lgren.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lgren.entity.Student;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Lgren
 * @since 2018-11-02
 */
public interface StudentMapper extends BaseMapper<Student> {

    int insertBatch(List<Student> studentList);

    int insertStudent(Student student);

    List<Student> selectAllStudent();
}
