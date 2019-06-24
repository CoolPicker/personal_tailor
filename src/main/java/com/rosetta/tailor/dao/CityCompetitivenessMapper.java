package com.rosetta.tailor.dao;

import com.rosetta.tailor.entity.CityCompetitiveness;

public interface CityCompetitivenessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CityCompetitiveness record);

    int insertSelective(CityCompetitiveness record);

    CityCompetitiveness selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CityCompetitiveness record);

    int updateByPrimaryKey(CityCompetitiveness record);

    CityCompetitiveness selectByPrimaryKey(String city);
}