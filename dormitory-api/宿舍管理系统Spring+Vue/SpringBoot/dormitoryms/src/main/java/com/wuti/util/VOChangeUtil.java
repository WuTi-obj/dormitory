package com.wuti.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuti.entity.Absent;
import com.wuti.entity.Building;
import com.wuti.entity.Dormitory;
import com.wuti.entity.Student;
import com.wuti.mapper.BuildingMapper;
import com.wuti.mapper.DormitoryAdminMapper;
import com.wuti.mapper.DormitoryMapper;
import com.wuti.mapper.StudentMapper;
import com.wuti.vo.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuti
 */
public class VOChangeUtil {
    //StudentVO转换
    public static PageVO studentChangePageVO(Page<Student> resultPage, DormitoryMapper dormitoryMapper){
        List<Student> studentList = resultPage.getRecords();
        //VO转换
        List<StudentVO> studentVOList = new ArrayList<>();
        for (Student student : studentList){
            StudentVO studentVO = new StudentVO();
            BeanUtils.copyProperties(student,studentVO);
            Dormitory dormitory = dormitoryMapper.selectById(student.getDormitoryId());
            studentVO.setDormitoryName(dormitory.getName());
            studentVOList.add(studentVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setData(studentVOList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    //BuildingVO转换
    public static PageVO buildingChangePageVO(Page<Building> resultPage, DormitoryAdminMapper dormitoryAdminMapper){
        //building转为BuildingVO
        List<BuildingVO> buildingVOList = new ArrayList<>();
        for (Building building : resultPage.getRecords()){
            BuildingVO buildingVO = new BuildingVO();
            BeanUtils.copyProperties(building, buildingVO);
            buildingVO.setAdminName(dormitoryAdminMapper.selectById(building.getAdminId()).getName());
            buildingVOList.add(buildingVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setData(buildingVOList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    //DormitoryVO转换
    public static PageVO dormitoryChangePageVO(Page<Dormitory> resultPage, BuildingMapper buildingMapper){
        List<DormitoryVO> dormitoryVOList = new ArrayList<>();
        for (Dormitory dormitory : resultPage.getRecords()){
            DormitoryVO dormitoryVO = new DormitoryVO();
            BeanUtils.copyProperties(dormitory,dormitoryVO);
            Building building = buildingMapper.selectById(dormitory.getBuildingId());
            dormitoryVO.setBuildingName(building.getName());
            dormitoryVOList.add(dormitoryVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setData(dormitoryVOList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

    public static PageVO absentChangePageVO(Page<Absent> resultPage, BuildingMapper buildingMapper, DormitoryMapper dormitoryMapper, StudentMapper studentMapper, DormitoryAdminMapper dormitoryAdminMapper){
        List<AbsentVO> absentVOList = new ArrayList<>();
        for (Absent absent : resultPage.getRecords()) {
            AbsentVO absentVO = new AbsentVO();
            BeanUtils.copyProperties(absent,absentVO);
            absentVO.setBuildingName(buildingMapper.selectById(absent.getBuildingId()).getName());
            absentVO.setDormitoryName(dormitoryMapper.selectById(absent.getDormitoryId()).getName());
            absentVO.setStudentName(studentMapper.selectById(absent.getStudentId()).getName());
            absentVO.setDormitoryAdminName(dormitoryAdminMapper.selectById(absent.getDormitoryAdminId()).getName());
            absentVOList.add(absentVO);
        }
        PageVO pageVO = new PageVO();
        pageVO.setData(absentVOList);
        pageVO.setTotal(resultPage.getTotal());
        return pageVO;
    }

}
