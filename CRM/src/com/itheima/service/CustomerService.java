package com.itheima.service;

import com.itheima.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    List<Customer> findAll();

    void deleteByCustId(Customer customer);

    Customer findByCustId(Customer customer);

    void update(Customer customer);

    List<Customer> findByCondition(DetachedCriteria detachedCriteria);
}
