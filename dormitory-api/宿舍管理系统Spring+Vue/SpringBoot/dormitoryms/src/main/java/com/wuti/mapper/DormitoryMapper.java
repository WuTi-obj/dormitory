package com.wuti.mapper;

import com.wuti.entity.Dormitory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuti
 */
public interface DormitoryMapper extends BaseMapper<Dormitory> {
    //宿舍-1
    public void subAvailable(Integer id);
    //宿舍+1
    public void addAvailable(Integer id);
    public Integer findAvailableDormitoryId();
}
