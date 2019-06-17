package com.itheima.dao;

import com.itheima.domain.Linkman;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface LinkmanDao {
    void save(Linkman linkman);

    List<Linkman> findByCondition(DetachedCriteria detachedCriteria);

    void deleteByLkmId(Linkman linkman);

    Linkman findByLkmId(Linkman linkman);

    void update(Linkman linkman);

    List<Linkman> findData(DetachedCriteria detachedCriteria, int startIndex, int pageSize);

    int findRecord(DetachedCriteria detachedCriteria);
}
