package com.itheima.web.action;

import com.itheima.domain.BaseDict;
import com.itheima.domain.Customer;
import com.itheima.service.BaseDictService;
import com.itheima.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
@Results({
        @Result(name = "addUI", location = "/jsp/customer/add.jsp"),
        @Result(name = "list", location = "/jsp/customer/list.jsp"),
        @Result(name = "editUI", location = "/jsp/customer/edit.jsp"),
        @Result(name = "findAll", location = "/customerAction_list", type = "redirect")
})

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();

    //准备一个字典表的service
    @Autowired
    private BaseDictService baseDictService;

    //准备一个客户表的service
    @Autowired
    private CustomerService customerService;

    //属性驱动
    private List<BaseDict> baseDictLevelList;
    private List<BaseDict> baseDictIndustryList;
    private List<BaseDict> baseDictSourceList;

    //(属性驱动返回客户列表集合)
    private List<Customer> customerList;

    @Action("customerAction_addUI")
    public String AddUI() {
        //调用service查询 字典表数据
        //查询级别
        baseDictLevelList = baseDictService.findBaseDictByCode("006");
        //查询所属行业
        baseDictIndustryList = baseDictService.findBaseDictByCode("001");
        //查询来源
        baseDictSourceList = baseDictService.findBaseDictByCode("009");
        //数据将给页显示，需要将数据放入值栈，手动或者自动（使用struts中的属性驱动）
        //将集合数据 封装成私有的成员变量 同时提供
        return "addUI";
    }

    /**
     * 客户的新增保存功能
     * @return
     */
    @Action("customerAction_save")
    public String save() {
        // System.out.println(customer);
        customerService.save(customer);
        return "findAll";
    }

    /**
     * 查询客户列表数据
     * @return
     */
    @Action("customerAction_list")
    public String list() {
        //查询客户列表的数据
        customerList = customerService.findAll();

        baseDictLevelList = baseDictService.findBaseDictByCode("006");
        baseDictIndustryList = baseDictService.findBaseDictByCode("001");
        baseDictSourceList = baseDictService.findBaseDictByCode("009");
        return "list";
    }

    /**
     * 删除客户列表数据
     * @return
     */
    @Action("customerAction_delete")
    public String delete() {
        //先获取客户 再删除客户信息
        //从数据库获得的用户 具有list集合 才可以进行级联删除
        Customer tempCustomer = customerService.findByCustId(customer);
        customerService.deleteByCustId(tempCustomer);
        return "findAll";
    }

    /**
     * 修改客户列表数据
     * @return
     */
    @Action("customerAction_editUI")
    public String editUI() {
        Customer tempCustomer = customerService.findByCustId(customer);

        baseDictLevelList = baseDictService.findBaseDictByCode("006");
        baseDictIndustryList = baseDictService.findBaseDictByCode("001");
        baseDictSourceList = baseDictService.findBaseDictByCode("009");

        ActionContext.getContext().getValueStack().set("tempCustomer", tempCustomer);
        return "editUI";
    }

    /**
     * 保持客户列表的数据并返回到客户列表
     * @return
     */
    @Action("customerAction_edit")
    public String edit() {
        customerService.update(customer);
        return "findAll";
    }


    @Action("customerAction_findByCondition")
    public String findByCondition() {
        //不管条件的部分，回去还是一样的页面，需要准备静态数据(下拉框数据)
        //1、需要查询下拉框的数据
        //调用service查询 字典表数据 下拉框的共有数据
        //查询级别
        baseDictLevelList = baseDictService.findBaseDictByCode("006");
        //查询所属行业
        baseDictIndustryList = baseDictService.findBaseDictByCode("001");
        //查询来源
        baseDictSourceList = baseDictService.findBaseDictByCode("009");

        //2、考虑查询sql的部分 hibernate提供了离线对象 可以封装条件
        //DetachedCriteria 游离 离线对象

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        //判断是否非空 如果不为空 添加条件 数据都被模型驱动封装了
        //isBlank字段字符串是否为null,或者是否为"" 如果是 返回true

        //判断名称
        if (!StringUtils.isBlank(customer.getCustName())) {
            //不为空 拼接条件
            detachedCriteria.add(Restrictions.like("custName", "%" + customer.getCustName() + "%"));
        }

        //判断级别
        if (customer.getBaseDictLevel() != null && !StringUtils.isBlank(customer.getBaseDictLevel().getDictId())) {
            detachedCriteria.add(Restrictions.eq("baseDictLevel.dictId", customer.getBaseDictLevel().getDictId()));
        }

        //判断来源
        if (customer.getBaseDictSource() != null && !StringUtils.isBlank(customer.getBaseDictSource().getDictId())) {
            detachedCriteria.add(Restrictions.eq("baseDictSource.dictId", customer.getBaseDictSource().getDictId()));
        }

        //判断所属行业
        if (customer.getBaseDictIndustry() != null && !StringUtils.isBlank(customer.getBaseDictIndustry().getDictId())) {
            detachedCriteria.add(Restrictions.eq("baseDictIndustry.dictId", customer.getBaseDictIndustry().getDictId()));
        }

        //表示sql拼接已经完成，只需要传入dao,调用api即可
        //返回值必须叫做customerList 因为查询所有也是这个名称
        customerList = customerService.findByCondition(detachedCriteria);
        return "list";
    }


    @Override
    public Customer getModel() {
        return customer;
    }

    public List<BaseDict> getBaseDictLevelList() {
        return baseDictLevelList;
    }

    public List<BaseDict> getBaseDictIndustryList() {
        return baseDictIndustryList;
    }

    public List<BaseDict> getBaseDictSourceList() {
        return baseDictSourceList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
