package com.rosetta.tailor.service;

import com.rosetta.tailor.dao.IdentifyCodePreMapper;
import com.rosetta.tailor.entity.IdentifyCodePre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 根据前缀获取编码对应区域
 */
@Service
public class IdentifyCodePreService {

    @Autowired
    private IdentifyCodePreMapper identifyCodePreMapper;

    /**
     * 根据编码获取区域信息
     * @param code
     * @return
     */
    public IdentifyCodePre queryByCode(Integer code,int size) {
        IdentifyCodePre identifyCodePre = new IdentifyCodePre();
        String str = code.toString();
        if (size >= 2 ) {
            identifyCodePre.setTwoCode(Integer.parseInt(str.substring(0,2)));
        }
        if (size >= 4 ) {
            identifyCodePre.setFourCode(Integer.parseInt(str.substring(0,4)));
        }
        if (size >= 6 ) {
            identifyCodePre.setSixCode(Integer.parseInt(str.substring(0,6)));
        }
        return identifyCodePreMapper.selectIdentifyDetailsByPre(identifyCodePre);
    }

}
