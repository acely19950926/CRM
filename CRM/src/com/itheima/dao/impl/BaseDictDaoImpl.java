package com.itheima.dao.impl;

import com.itheima.dao.BaseDictDao;
import com.itheima.domain.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseDictDaoImpl implements BaseDictDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<BaseDict> findBaseDictByCode(String typeCode) {
        return (List<BaseDict>) hibernateTemplate.find("from BaseDict where dictTypeCode = ?", typeCode);
    }
}
