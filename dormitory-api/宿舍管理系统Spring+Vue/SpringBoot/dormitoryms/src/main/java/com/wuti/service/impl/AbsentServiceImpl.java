package com.wuti.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuti.entity.*;
import com.wuti.form.SearchForm;
import com.wuti.mapper.*;
import com.wuti.service.AbsentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuti.util.VOChangeUtil;
import com.wuti.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuti
 */
@Service
public class AbsentServiceImpl extends ServiceImpl<AbsentMapper, Absent> implements AbsentService {

    @Autowired
    private AbsentMapper absentMapper;
    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    @Override
    public PageVO list(Integer page, Integer size) {
        Page<Absent> absentPage = new Page<>(page, size);
        Page<Absent> resultPage = this.absentMapper.selectPage(absentPage, null);
        //VO转换
        return VOChangeUtil.absentChangePageVO(resultPage, buildingMapper, dormitoryMapper ,studentMapper, dormitoryAdminMapper);
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        Page<Absent> absentPage = new Page<>(searchForm.getPage(), searchForm.getSize());
        Page<Absent> resultPage = null;
        if (searchForm.getValue().equals("")){
            resultPage = this.absentMapper.selectPage(absentPage, null);
        } else {
            QueryWrapper<Absent> queryWrapper = new QueryWrapper<>();
            //如果key为studentName用querywrapper取一下student_id的list赋给querywrapper
            if (searchForm.getKey().equals("buildingName")){
                QueryWrapper<Building> buildingQueryWrapper = new QueryWrapper<>();
                buildingQueryWrapper.like("name", searchForm.getValue());
                List<Building> buildingList = this.buildingMapper.selectList(buildingQueryWrapper);
                List<Integer> idList = new ArrayList<>();
                for (Building building : buildingList){
                    idList.add(building.getId());
                }
                queryWrapper.in("building_id", idList);
            }
            //如果key为dormitoryName用querywrapper取一下dormitory_id的list赋给querywrapper
            if(searchForm.getKey().equals("dormitoryName")){
                QueryWrapper<Dormitory> dormitoryQueryWrapper = new QueryWrapper<>();
                dormitoryQueryWrapper.like("name", searchForm.getValue());
                List<Dormitory> dormitoryList = this.dormitoryMapper.selectList(dormitoryQueryWrapper);
                List<Integer> idList = new ArrayList<>();
                for (Dormitory dormitory : dormitoryList) {
                    idList.add(dormitory.getId());
                }
                queryWrapper.in("dormitory_id", idList);
            }
            resultPage = this.absentMapper.selectPage(absentPage, queryWrapper);
        }
        //VO转换
        return VOChangeUtil.absentChangePageVO(resultPage, buildingMapper, dormitoryMapper ,studentMapper, dormitoryAdminMapper);
    }

    @Override
    public Boolean deleteById(Integer id) {
        //删除absent表数据
        int delete = this.absentMapper.deleteById(id);
        if (delete != 1) return false;
        return true;
    }

//    @Override
//    public List<Building> findBuildingByAdminId(Integer id) {
//        List<Building> buildingList = this.buildingMapper.findBuildingByAdminId(id);
//        return buildingList;
//    }
}
