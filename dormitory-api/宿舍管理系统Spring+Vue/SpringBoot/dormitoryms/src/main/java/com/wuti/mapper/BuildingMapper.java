package com.wuti.mapper;

import com.wuti.entity.Building;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuti
 */
public interface BuildingMapper extends BaseMapper<Building> {
    public List<Building> findBuildingByAdminId(@Param("adminId") Integer adminId);
}
