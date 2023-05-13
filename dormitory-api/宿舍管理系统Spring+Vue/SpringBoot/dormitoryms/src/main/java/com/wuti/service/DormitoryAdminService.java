package com.wuti.service;

import com.wuti.entity.DormitoryAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuti.form.RuleFrom;
import com.wuti.form.SearchForm;
import com.wuti.vo.PageVO;
import com.wuti.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuti
 */
public interface DormitoryAdminService extends IService<DormitoryAdmin> {

    public ResultVO login(RuleFrom ruleFrom);
    public PageVO list(Integer page,Integer size);
    public PageVO search(SearchForm searchForm);

}
