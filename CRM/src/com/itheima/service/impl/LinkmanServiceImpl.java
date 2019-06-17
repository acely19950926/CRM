package com.itheima.service.impl;

import com.itheima.dao.LinkmanDao;
import com.itheima.domain.Linkman;
import com.itheima.domain.PageBean;
import com.itheima.service.LinkmanService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LinkmanServiceImpl implements LinkmanService {

    @Autowired
    private LinkmanDao linkmanDao;

    @Override
    public void save(Linkman linkman) {
        linkmanDao.save(linkman);
    }

    // @Override
    // public List<Linkman> findByCondition(DetachedCriteria detachedCriteria) {
    //     return linkmanDao.findByCondition(detachedCriteria);
    // }

    /**
     * 分页的方法
     * @param detachedCriteria
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Linkman> findByCondition(DetachedCriteria detachedCriteria, int pageNumber, int pageSize) {
        //1、创建PageBean
        PageBean<Linkman> pageBean = new PageBean<>(pageNumber, pageSize);

        // - 查询总记录数
        // 实际语句：select * from Linkman where 条件 limit ?,?
        // 目标语句：select count(*) from Linkman where 条件
        //例如：数据库一共50条数据 条件查询 男的数据一共25条 detachedCriteria里封装了条件
        // 调换位置 成功
        //sql每页limit,但是查询不是count(*) 而是还是* 需要设置投影查询
        // 当设置了投影查询时，下面查询分页数据的代码，也变成count(*) 这不是我们想要的结果 我们想要的就是*
        //以后将查询总记录数放在前面 将查询分页数据放在后面 理由：如果是查询分页数据，自动封装 开始索引和每页显示个数不能拆分出来
        //而投影查询时可以自己设置的 涉及到分页查询时，只需要将投影查询设置成null即可，会覆盖之前的投影
        detachedCriteria.setProjection(Projections.rowCount());
        int totalRecord = linkmanDao.findRecord(detachedCriteria);

        //4、查询分页数据
        // - 查询分页的数据
        // 传入的参数 select * from Linkman where 条件 limit ?,?
        // 传入离线对象和开始索引,每页显示个数时， 自动将后两个参数封装到离线对象中 在查询总记录数时，会出现异常
        detachedCriteria.setProjection(null);
        List<Linkman> data = linkmanDao.findData(detachedCriteria, pageBean.getStartIndex(), pageSize);

        //3、赋值pageBean
        pageBean.setData(data); //赋值分页数据
        pageBean.setTotalRecord(totalRecord);   //赋值总记录数据

        //2、返回pageBean
        return pageBean;
    }

    @Override
    public void deleteByLkmId(Linkman linkman) {
        linkmanDao.deleteByLkmId(linkman);
    }

    @Override
    public Linkman findByLkmId(Linkman linkman) {
        return linkmanDao.findByLkmId(linkman);
    }

    @Override
    public void update(Linkman linkman) {
        linkmanDao.update(linkman);
    }


}
