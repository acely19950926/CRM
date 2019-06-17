package com.itheima.web.action;

import com.itheima.domain.Customer;
import com.itheima.domain.Linkman;
import com.itheima.domain.PageBean;
import com.itheima.service.CustomerService;
import com.itheima.service.LinkmanService;
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
        @Result(name = "addUI", location = "/jsp/linkman/add.jsp"),
        @Result(name = "list", location = "/jsp/linkman/list.jsp"),
        @Result(name = "findAll", location = "/linkmanAction_findByCondition", type = "redirect"),
        @Result(name = "editUI", location = "/jsp/linkman/edit.jsp")
})
public class LinkmanAction extends ActionSupport implements ModelDriven<Linkman> {

    private Linkman linkman = new Linkman();

    @Autowired
    private CustomerService customerService;
    @Autowired
    private LinkmanService linkmanService;

    //属性驱动
    private List<Customer> customerList;
    private int pageNumber = 1; //使用属性驱动接收pageNumber即可

    /**
     * 根据id修改联系人数据
     * @return
     */
    @Action("linkmanAction_edit")
    public String edit() {
        linkmanService.update(linkman);
        return "findAll";
    }

    /**
     * 根据联系人ID查询联系人信息
     * @return
     */
    @Action("linkmanAction_editUI")
    public String editUI() {
        //1、查询客户的信息
        //查询客户列表数据 放入值栈 属性驱动已经将数据放入了值栈
        customerList = customerService.findAll();

        //2.查询联系人信息
        Linkman tempLinkman = linkmanService.findByLkmId(linkman);
        //将联系人信息放入值栈 手动放入
        ActionContext.getContext().getValueStack().set("tempLinkman", tempLinkman);
        return "editUI";
    }

    /**
     * 联系人删除
     */
    @Action("linkmanAction_deleteByLkmId")
    public String deleteByLkmId() {
        System.err.println("ID:" + linkman);
        linkmanService.deleteByLkmId(linkman);
        return "findAll";
    }


    /**
     * 条件查询
     */
    @Action("linkmanAction_findByCondition")
    public String findByCondition() {
        // int pageNumber = 1;
        int pageSize = 2;

        //1、需要查询所属客户信息放在页面上
        customerList = customerService.findAll();

        //拼接条件
        //如果要使用拼接条件，使用DetachedCriteria
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Linkman.class);

        //判断名称是否存在
        if (!StringUtils.isBlank(linkman.getLkmName())) {
            detachedCriteria.add(Restrictions.like("lkmName", "%" + linkman.getLkmName() + "%"));
        }

        //判断性别是否存在
        if (!StringUtils.isBlank(linkman.getLkmGender())) {
            detachedCriteria.add(Restrictions.eq("lkmGender", linkman.getLkmGender()));
        }

        //判断所属客户是否存在 Long类型 需要特殊判断
        //需要先判断对象是否为null
        if (linkman.getCustomer() != null && linkman.getCustomer().getCustId() != null) {
            detachedCriteria.add(Restrictions.eq("customer.custId", linkman.getCustomer().getCustId()));
        }

        //查询联系人的数据
        // List<Linkman> linkmanList = linkmanService.findByCondition(detachedCriteria);
        PageBean<Linkman> pageBean = linkmanService.findByCondition(detachedCriteria, pageNumber, pageSize);

        //手动将值放入值栈
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);

        return "list";
    }

    /**
     * 添加前显示客户集合数据
     * @return
     */
    @Action("linkmanAction_addUI")
    public String addUI() {
        customerList = customerService.findAll();   //返回所属客户
        return "addUI";
    }

    /**
     * 新增联系人功能
     * @return
     */
    @Action("linkmanAction_add")
    public String add() {
        linkmanService.save(linkman);
        return "findAll";
    }

    @Override
    public Linkman getModel() {
        return linkman;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
