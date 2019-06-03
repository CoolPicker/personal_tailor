package com.rosetta.tailor.dao;

import com.rosetta.tailor.entity.TailorUser;
import com.rosetta.tailor.entity.TailorUserEnhance;

import java.util.List;

public interface TailorUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TailorUser record);

    int insertSelective(TailorUser record);

    TailorUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TailorUser record);

    int updateByPrimaryKey(TailorUser record);

    List<TailorUser> selectUsersCondition(TailorUserEnhance enhance);
}