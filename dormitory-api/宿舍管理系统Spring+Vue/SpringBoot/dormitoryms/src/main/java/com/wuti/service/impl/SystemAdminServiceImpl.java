package com.wuti.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wuti.entity.SystemAdmin;
import com.wuti.form.RuleFrom;
import com.wuti.mapper.SystemAdminMapper;
import com.wuti.service.SystemAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuti.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuti
 */
@Service
public class SystemAdminServiceImpl extends ServiceImpl<SystemAdminMapper, SystemAdmin> implements SystemAdminService {

    @Autowired
    public SystemAdminMapper systemAdminMapper;

    @Override
    public ResultVO login(RuleFrom ruleFrom) {
        //1、判断用户名是否存在
        QueryWrapper<SystemAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",ruleFrom.getUsername());
        SystemAdmin systemAdmin = this.systemAdminMapper.selectOne(queryWrapper);
        ResultVO resultVO = new ResultVO();
        if (systemAdmin == null){
            resultVO.setCode(-1);
        } else {
            //2、判断密码是否正确
            if (!systemAdmin.getPassword().equals(ruleFrom.getPassword())){
                resultVO.setCode(-2);
            } else {
                resultVO.setCode(0);
                resultVO.setData(systemAdmin);
            }
        }
        return resultVO;
    }

}
