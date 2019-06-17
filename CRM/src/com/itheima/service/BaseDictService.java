package com.itheima.service;

import com.itheima.domain.BaseDict;

import java.util.List;

public interface BaseDictService {
    List<BaseDict> findBaseDictByCode(String typeCode);
}
