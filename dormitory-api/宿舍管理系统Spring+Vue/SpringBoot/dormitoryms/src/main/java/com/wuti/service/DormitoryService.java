package com.wuti.service;

import com.wuti.entity.Dormitory;
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
public interface DormitoryService extends IService<Dormitory> {
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean deleteById(Integer id);
}
