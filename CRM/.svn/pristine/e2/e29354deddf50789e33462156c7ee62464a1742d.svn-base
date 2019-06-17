package com.itheima.dao.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(Customer customer) {
        hibernateTemplate.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) hibernateTemplate.find("from Customer");
    }

    @Override
    public void deleteByCustId(Customer customer) {
        hibernateTemplate.delete(customer);
    }

    @Override
    public Customer findByCustId(Customer customer) {
        return hibernateTemplate.get(Customer.class, customer.getCustId());
    }

    @Override
    public void update(Customer customer) {
        hibernateTemplate.update(customer);
    }

    @Override
    public List<Customer> findByCondition(DetachedCriteria detachedCriteria) {
        //会自动转换成在线对象进行查询
        return (List<Customer>) hibernateTemplate.findByCriteria(detachedCriteria);
    }
}
