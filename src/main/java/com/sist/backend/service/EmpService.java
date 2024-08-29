package com.sist.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.backend.mapper.EmpMapper;
import com.sist.backend.vo.EmpVO;

@Service
public class EmpService {

    @Autowired
    EmpMapper empMapper;

    public EmpVO[] all() {
        EmpVO[] ar = null;

        List<EmpVO> list = empMapper.all();
        if (list != null && list.size() > 0) {
            ar = new EmpVO[list.size()];
            list.toArray(ar);
        }

        return ar;
    }
}
