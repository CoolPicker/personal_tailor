package com.rosetta.tailor.controller;

import com.rosetta.tailor.entity.Code;
import com.rosetta.tailor.entity.Ret;
import com.rosetta.tailor.entity.TailorUser;
import com.rosetta.tailor.entity.TailorUserEnhance;
import com.rosetta.tailor.service.TailorUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "人员管理")
@RequestMapping("/user")
public class TailorUserController {

    @Autowired
    private TailorUserService tailorUserService;

    @ApiOperation(value = "人员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "姓名",paramType = "query"),
            @ApiImplicitParam(name = "age",value = "年龄",paramType = "query"),
            @ApiImplicitParam(name = "pageNum",value = "起始页",paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "页大小",paramType = "query"),
            @ApiImplicitParam(name = "orderBy",value = "排序字段",paramType = "query"),
            @ApiImplicitParam(name = "desc",value = "排序规则",paramType = "query")
    })
    @PostMapping("/list")
    public Ret userListCondition(String name,
                                 Integer age,
                                 Integer pageNum,
                                 Integer pageSize,
                                 String orderBy,
                                 String desc) {
        Ret ret = new Ret();
        ret.setState(Code.SUCCESS);
        TailorUserEnhance enhance = new TailorUserEnhance();
        enhance.setName(name);
        enhance.setAge(age);
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        enhance.setPagenum(pageNum);
        enhance.setPagesize(pageSize);
        enhance.setOrderby(orderBy);
        enhance.setDesc(desc);
        ret.setData(tailorUserService.getUsersCondition(enhance));
        return ret;
    }

}
