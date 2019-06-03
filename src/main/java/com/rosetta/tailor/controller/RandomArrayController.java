package com.rosetta.tailor.controller;

import com.alibaba.fastjson.JSONObject;
import com.rosetta.tailor.entity.Code;
import com.rosetta.tailor.entity.Ret;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "随机数组")
@RestController
@RequestMapping("/array")
public class RandomArrayController {


    private static DecimalFormat df = new DecimalFormat("0.000");

    @ApiOperation(value = "获取随机数组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "min",value = "最小值",paramType = "path"),
            @ApiImplicitParam(name = "max",value = "最大值",paramType = "path"),
            @ApiImplicitParam(name = "avg",value = "平均值",paramType = "path"),
            @ApiImplicitParam(name = "distance",value = "浮动区间",paramType = "path"),
            @ApiImplicitParam(name = "length",value = "长度",paramType = "path")
    })
    @GetMapping("/randomGet/{min}/{max}/{avg}/{distance}/{length}")
    public Ret getArrays(@PathVariable("min") double min,
                         @PathVariable("max") double max,
                         @PathVariable("avg") double avg,
                         @PathVariable("distance") double distance,
                         @PathVariable("length") int length) {
        Ret ret = new Ret();
        ret.setState(Code.SUCCESS);
        JSONObject json = new JSONObject();
        json.put("min",min);
        json.put("max",max);
        json.put("avg",avg);
        json.put("distance",distance);
        json.put("length",length);
        try {
            System.out.println("get: " + json.toJSONString());
            String res = test1(min,max,avg,distance,length);
            json.put("array",res);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setState(Code.FALI);
        }
        ret.setData(json);
        return ret;
    }

    @ApiOperation(value = "获取随机数组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "min",value = "最小值",paramType = "query"),
            @ApiImplicitParam(name = "max",value = "最大值",paramType = "query"),
            @ApiImplicitParam(name = "avg",value = "平均值",paramType = "query"),
            @ApiImplicitParam(name = "distance",value = "浮动区间",paramType = "query"),
            @ApiImplicitParam(name = "length",value = "长度",paramType = "query")
    })
    @PostMapping("/randomPost")
    public Ret randomArraysPost(double min,
                                double max,
                                double avg,
                                double distance,
                                int length) {
        Ret ret = new Ret();
        ret.setState(Code.SUCCESS);
        JSONObject json = new JSONObject();
        json.put("min",min);
        json.put("max",max);
        json.put("avg",avg);
        json.put("distance",distance);
        json.put("length",length);
        try {
            System.out.println("post: " + json.toJSONString());
            String res = test1(min,max,avg,distance,length);
            json.put("array",res);
        } catch (Exception e) {
            e.printStackTrace();
            ret.setState(Code.FALI);
        }
        ret.setData(json);
        return ret;
    }



    String test1(double minTemp,double maxTemp,double avgTemp,double distanceTemp,int length){
        List<String> list = new ArrayList<>();
        double all = 0.0;
        for (int i = 0 ; i < length ; i ++) {
            double disperseScore;
            if (i > (length / 4 + 1)) {
                disperseScore = getReal(all,avgTemp,maxTemp,minTemp,distanceTemp,i);
            } else {
                disperseScore = getDisperseScore(avgTemp, maxTemp, minTemp);
            }

            list.add(df.format(disperseScore));
            all+=disperseScore;
        }
        System.out.println(all/length);
        return StringUtils.join(list,"/");
    }


    double getReal(double all,double avg,double max,double min,double distance,int i) {
        double round = getDisperseScore(avg, max, min);
        double haha = all;
        double beforeAvg = all / (i);
        all += round;
        double nowAvg = all / (i+1);
        boolean bool = Math.abs(nowAvg - avg ) < distance || Math.abs(nowAvg - avg) < Math.abs(beforeAvg - avg);
        if (bool) {
            return round;
        } else {
            return getReal(haha,avg,max,min,distance,i);
        }
    }

    double getDisperseScore(Double avgScore,Double max,Double min){
        double result;
        if(Math.random()>0.5){
            double abs = Math.abs(max - avgScore);
            result =  avgScore+Math.random()*abs;
        }else{
            double abs = Math.abs(avgScore - min);
            result =  avgScore-Math.random()*abs;
        }
        return result;
    }

}
