package com.wuti.service;

import com.wuti.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuti.form.SearchForm;
import com.wuti.form.StudentForm;
import com.wuti.vo.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuti
 */
public interface StudentService extends IService<Student> {
    public Boolean saveStudent(Student student);
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean update(StudentForm studentForm);
    public Boolean deleteById(Integer id);
}
