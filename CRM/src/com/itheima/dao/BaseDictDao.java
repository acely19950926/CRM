package com.itheima.dao;

import com.itheima.domain.BaseDict;

import java.util.List;

public interface BaseDictDao {
    List<BaseDict> findBaseDictByCode(String typeCode);
}
