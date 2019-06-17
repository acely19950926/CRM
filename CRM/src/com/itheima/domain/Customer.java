package com.itheima.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cst_customer")
public class Customer {
    @Id
    @Column(name = "cust_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;    //客户编号

    @Column(name = "cust_name")
    private String custName; //客户名称

    @Column(name = "cust_phone")
    private String custPhone; //固定电话

    @Column(name = "cust_mobile")
    private String custMobile; //移动电话

    //描述一对多
    // mappedBy = "customer" 操作LinkMan时，不会操作customer属性
    //集合为什么需要实例化 ->>> 因为操作的同时如果不提前实例化，可能会出现需要在外部先实例化集合,然后赋值
    //如果已经提前赋值 可以直接获得对象即可
    //描述一对多 需要在一方添加级联删除
    @OneToMany(targetEntity = Linkman.class,mappedBy = "customer",cascade = CascadeType.REMOVE)
    private List<Linkman> linkmans = new ArrayList<>();

    /**
     * @JoinColumn(name="数据库中新增列的名称"， referencedColumnName="指向主表的主键")
     */
    //特殊字段
    //多对一
    @ManyToOne(targetEntity = BaseDict.class)
    @JoinColumn(name = "cust_source", referencedColumnName = "dict_id")   //往数据库表中加入一列
    private BaseDict baseDictSource; //客户信息来源

    @ManyToOne(targetEntity = BaseDict.class)
    @JoinColumn(name = "cust_level", referencedColumnName = "dict_id")   //往数据库表中加入一列
    private BaseDict baseDictLevel; //客户级别

    @ManyToOne(targetEntity = BaseDict.class)
    @JoinColumn(name = "cust_industry", referencedColumnName = "dict_id")   //往数据库表中加入一列
    private BaseDict baseDictIndustry; // 客户所属行业


    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public BaseDict getBaseDictSource() {
        return baseDictSource;
    }

    public void setBaseDictSource(BaseDict baseDictSource) {
        this.baseDictSource = baseDictSource;
    }

    public BaseDict getBaseDictLevel() {
        return baseDictLevel;
    }

    public void setBaseDictLevel(BaseDict baseDictLevel) {
        this.baseDictLevel = baseDictLevel;
    }

    public BaseDict getBaseDictIndustry() {
        return baseDictIndustry;
    }

    public void setBaseDictIndustry(BaseDict baseDictIndustry) {
        this.baseDictIndustry = baseDictIndustry;
    }

    public List<Linkman> getLinkmans() {
        return linkmans;
    }

    public void setLinkmans(List<Linkman> linkmans) {
        this.linkmans = linkmans;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custMobile='" + custMobile + '\'' +
                ", baseDictSource=" + baseDictSource +
                ", baseDictLevel=" + baseDictLevel +
                ", baseDictIndustry=" + baseDictIndustry +
                '}';
    }
}
