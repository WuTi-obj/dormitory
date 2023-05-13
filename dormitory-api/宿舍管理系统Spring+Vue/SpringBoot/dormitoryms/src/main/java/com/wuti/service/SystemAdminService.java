package com.wuti.service;

import com.wuti.entity.SystemAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wuti.form.RuleFrom;
import com.wuti.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuti
 */
public interface SystemAdminService extends IService<SystemAdmin> {

    public ResultVO login(RuleFrom ruleFrom);

}
