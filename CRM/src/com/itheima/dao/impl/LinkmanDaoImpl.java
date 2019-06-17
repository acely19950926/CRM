package com.itheima.dao.impl;

import com.itheima.dao.LinkmanDao;
import com.itheima.domain.Linkman;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LinkmanDaoImpl implements LinkmanDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(Linkman linkman) {
        hibernateTemplate.save(linkman);
    }

    @Override
    public List<Linkman> findByCondition(DetachedCriteria detachedCriteria) {
        return (List<Linkman>) hibernateTemplate.findByCriteria(detachedCriteria);
    }

    @Override
    public void deleteByLkmId(Linkman linkman) {
        hibernateTemplate.delete(linkman);
    }

    @Override
    public Linkman findByLkmId(Linkman linkman) {
        return hibernateTemplate.get(linkman.getClass(), linkman.getLkmId());
    }

    @Override
    public void update(Linkman linkman) {
        hibernateTemplate.update(linkman);
    }

    /**
     * 查询分页数据
     * select * from Linkman
     * @param detachedCriteria
     * @param startIndex
     * @param pageSize
     * @return List<Linkman>
     */
    @Override
    public List<Linkman> findData(DetachedCriteria detachedCriteria, int startIndex, int pageSize) {
        return (List<Linkman>) hibernateTemplate.findByCriteria(detachedCriteria, startIndex, pageSize);
    }

    /**
     * 查询总记录数
     * select count(*) from Linkman where 条件
     * @param detachedCriteria
     * @return 一个结果
     */
    @Override
    public int findRecord(DetachedCriteria detachedCriteria) {
        List<?> findByCriteria = hibernateTemplate.findByCriteria(detachedCriteria);
        if (findByCriteria != null && findByCriteria.size() > 0) {
            return Integer.valueOf(findByCriteria.get(0).toString());
        }
        return 0;
    }
}
