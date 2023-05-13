package com.wuti.service;

import com.wuti.entity.Moveout;
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
public interface MoveoutService extends IService<Moveout> {
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean moveout(Integer id, String reason);
    public PageVO moveoutList(Integer page, Integer size);
    public PageVO moveoutSearch(SearchForm searchForm);
}
