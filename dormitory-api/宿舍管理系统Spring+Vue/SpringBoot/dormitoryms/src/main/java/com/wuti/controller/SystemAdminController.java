package com.wuti.controller;


import com.wuti.form.RuleFrom;
import com.wuti.service.SystemAdminService;
import com.wuti.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuti
 */
@RestController
@RequestMapping("/systemAdmin")
public class SystemAdminController {

    @Autowired
    private SystemAdminService systemAdminService;

    @GetMapping("/login")
    public ResultVO login(RuleFrom ruleFrom){
        ResultVO resultVO = this.systemAdminService.login(ruleFrom);
        return resultVO;
    }

}

