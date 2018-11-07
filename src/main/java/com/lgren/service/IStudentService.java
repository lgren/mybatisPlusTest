package com.lgren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lgren.entity.Student;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Lgren
 * @since 2018-11-02
 */
public interface IStudentService extends IService<Student> {

    int insertBatch(Collection<Student> studentList, Integer batchCount);

    int insertBatchAutoCalLen(Collection<Student> studentList, int toStringMaxLengthOfOne);

    int insertStudent(Student student);

    List<Student> selectAllStudent();

}
