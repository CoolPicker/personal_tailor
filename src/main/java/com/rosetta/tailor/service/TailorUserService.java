package com.rosetta.tailor.service;

import com.github.pagehelper.PageInfo;
import com.rosetta.tailor.dao.TailorUserMapper;
import com.rosetta.tailor.entity.TailorUser;
import com.rosetta.tailor.entity.TailorUserEnhance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TailorUserService {

    @Autowired
    private TailorUserMapper tailorUserMapper;

    /**
     * 获取人员列表
     * @param enhance
     * @return
     */
    public Object getUsersCondition(TailorUserEnhance enhance) {
        List<TailorUser> tailorUsers = tailorUserMapper.selectUsersCondition(enhance);
        PageInfo<TailorUser> page = new PageInfo<>(tailorUsers);
        return page;
    }

}
