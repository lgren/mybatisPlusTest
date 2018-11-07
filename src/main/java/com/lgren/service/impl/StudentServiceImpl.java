package com.lgren.service.impl;

import com.lgren.entity.Student;
import com.lgren.mapper.StudentMapper;
import com.lgren.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lgren.util.LgrenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Optional.ofNullable;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lgren
 * @since 2018-11-02
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int insertBatch(Collection<Student> studentList, Integer batchCount) {
        return LgrenUtil.getAllList(new ArrayList<>(studentList), Math.max(ofNullable(batchCount).orElse(500), 500)).parallelStream()
                .mapToInt(studentMapper::insertBatch).sum();
    }

    @Override
    public int insertBatchAutoCalLen(Collection<Student> studentList, int batchCount) {
        return LgrenUtil.getAllList(new ArrayList<>(studentList), 4 * 1024 * 1024 / batchCount).parallelStream()
                .mapToInt(studentMapper::insertBatch).sum();
    }

    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }

    @Override
    public List<Student> selectAllStudent() {
        return studentMapper.selectAllStudent();
    }
}
