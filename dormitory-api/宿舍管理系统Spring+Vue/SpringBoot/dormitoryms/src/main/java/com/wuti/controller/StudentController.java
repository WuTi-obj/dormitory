package com.wuti.controller;

import com.wuti.entity.Student;
import com.wuti.form.SearchForm;
import com.wuti.form.StudentForm;
import com.wuti.service.DormitoryService;
import com.wuti.service.StudentService;
import com.wuti.util.ResultVOUtil;
import com.wuti.vo.ResultVO;
import com.wuti.vo.StudentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuti
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private DormitoryService dormitoryService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Student student){
        Boolean saveStudent = this.studentService.saveStudent(student);
        if (!saveStudent) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        return ResultVOUtil.success(this.studentService.list(page,size));
    }

    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        return ResultVOUtil.success(this.studentService.search(searchForm));
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id){
        Student student = this.studentService.getById(id);
        StudentForm studentForm = new StudentForm();
        StudentVO studentVO = new StudentVO();
        studentVO.setDormitoryName(this.dormitoryService.getById(student.getDormitoryId()).getName());
        BeanUtils.copyProperties(studentVO, studentForm);
        BeanUtils.copyProperties(student, studentForm);
        studentForm.setOldDormitoryId(student.getDormitoryId());
        return ResultVOUtil.success(studentForm);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody StudentForm studentForm){
        Boolean update = this.studentService.update(studentForm);
        if (!update) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") Integer id){
        Boolean delete = this.studentService.deleteById(id);
        if (!delete) return ResultVOUtil.fail();
        return ResultVOUtil.success(null);
    }
}

