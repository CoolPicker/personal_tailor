package com.rosetta.tailor.dao;

import com.rosetta.tailor.entity.IdentifyCodePre;

public interface IdentifyCodePreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IdentifyCodePre record);

    int insertSelective(IdentifyCodePre record);

    IdentifyCodePre selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IdentifyCodePre record);

    int updateByPrimaryKey(IdentifyCodePre record);

    IdentifyCodePre selectIdentifyDetailsByPre(IdentifyCodePre pre);
}