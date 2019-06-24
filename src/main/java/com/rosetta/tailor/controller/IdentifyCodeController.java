package com.rosetta.tailor.controller;

import com.rosetta.tailor.entity.Code;
import com.rosetta.tailor.entity.IdentifyCodePre;
import com.rosetta.tailor.entity.Ret;
import com.rosetta.tailor.service.IdentifyCodePreService;
import com.rosetta.tailor.util.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "身份证编码")
@RestController
@RequestMapping("/id")
public class IdentifyCodeController {

    @Autowired
    private IdentifyCodePreService identifyCodePreService;

    @ApiOperation(value = "获取身份证编码对应详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code",value = "编码",paramType = "path")
    })
    @GetMapping("/identifyDetails/{code}")
    public Ret getIdentifyDetailsByCode(@PathVariable("code") Integer code) {
        Ret ret = new Ret();
        try {
            int size = CommonUtils.sizeOfInt(code);
            if (CommonUtils.sizeOfInt(code) > 1) {
                ret.setState(Code.SUCCESS);
                System.out.println("identify code : " + code);
                IdentifyCodePre identifyCodePre = identifyCodePreService.queryByCode(code,size);
                ret.setData(identifyCodePre);
            } else {
                ret.setState(Code.FALI);
                ret.setCode("102");
                ret.setMsg("编码至少为两位数");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ret.setState(Code.FALI);
        }
        return ret;
    }



}
