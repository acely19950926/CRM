package com.itheima.service.impl;

import com.itheima.dao.BaseDictDao;
import com.itheima.domain.BaseDict;
import com.itheima.service.BaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictDao baseDictDao;

    @Override
    public List<BaseDict> findBaseDictByCode(String typeCode) {
        //调用dao数据即可
        return baseDictDao.findBaseDictByCode(typeCode);
    }
}
