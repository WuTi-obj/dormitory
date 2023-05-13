package com.wuti.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuti.entity.Dormitory;
import com.wuti.entity.Student;
import com.wuti.form.SearchForm;
import com.wuti.mapper.BuildingMapper;
import com.wuti.mapper.DormitoryMapper;
import com.wuti.mapper.StudentMapper;
import com.wuti.service.DormitoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuti.util.VOChangeUtil;
import com.wuti.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuti
 */
@Service
public class DormitoryServiceImpl extends ServiceImpl<DormitoryMapper, Dormitory> implements DormitoryService {

    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageVO list(Integer page, Integer size) {
        Page<Dormitory> dormitoryPage = new Page<>(page,size);
        Page<Dormitory> resultPage = this.dormitoryMapper.selectPage(dormitoryPage, null);
        //VO转换
        return VOChangeUtil.dormitoryChangePageVO(resultPage, buildingMapper);
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        Page<Dormitory> dormitoryPage = new Page<>(searchForm.getPage(),searchForm.getSize());
        Page<Dormitory> resultPage = null;
        if (searchForm.getValue().equals("")){
            resultPage = this.dormitoryMapper.selectPage(dormitoryPage, null);
        } else {
            QueryWrapper<Dormitory> queryWrapper =new QueryWrapper<>();
            queryWrapper.like(searchForm.getKey(), searchForm.getValue());
            resultPage = this.dormitoryMapper.selectPage(dormitoryPage, queryWrapper);
        }
        //VO转换
        return VOChangeUtil.dormitoryChangePageVO(resultPage, buildingMapper);
    }

    @Override
    public Boolean deleteById(Integer id) {
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq("dormitory_id", id);
        List<Student> studentList = this.studentMapper.selectList(studentQueryWrapper);
        for (Student student : studentList) {
            Integer availableDormitoryId = this.dormitoryMapper.findAvailableDormitoryId();
            student.setDormitoryId(availableDormitoryId);
            try {
                this.studentMapper.updateById(student);
                this.dormitoryMapper.subAvailable(availableDormitoryId);
            } catch (Exception e) {
                return false;
            }
        }
        int delete = this.dormitoryMapper.deleteById(id);
        if (delete != 1) return false;
        return true;
    }
}
