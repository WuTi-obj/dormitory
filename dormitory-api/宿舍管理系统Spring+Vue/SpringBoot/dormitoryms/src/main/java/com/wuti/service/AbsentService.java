package com.wuti.service;

import com.wuti.entity.Absent;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuti.form.SearchForm;
import com.wuti.vo.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuti
 */
public interface AbsentService extends IService<Absent> {
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean deleteById(Integer id);
//    public List<Building> findBuildingByAdminId(Integer id);
}
