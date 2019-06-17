package com.itheima.service;

import com.itheima.domain.Linkman;
import com.itheima.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface LinkmanService {
    void save(Linkman linkman);

    // List<Linkman> findByCondition(DetachedCriteria detachedCriteria);

    void deleteByLkmId(Linkman linkman);

    Linkman findByLkmId(Linkman linkman);

    void update(Linkman linkman);

    PageBean<Linkman> findByCondition(DetachedCriteria detachedCriteria, int pageNumber, int pageSize);
}
