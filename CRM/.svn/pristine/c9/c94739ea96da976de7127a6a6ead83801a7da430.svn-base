package com.itheima.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_base_dict")
public class BaseDict {

    @Id
    @Column(name = "dict_id")
    private String dictId;      //主键

    @Column(name = "dict_type_code")
    private String dictTypeCode;      //类别码 001 002 003

    @Column(name = "dict_type_name")
    private String dictTypeName;    //类别名称 对类别码的进行描述 就是表名

    @Column(name = "dict_item_name")    //每个字段自己的名称
    private String dictItemName;

    @Column(name = "dict_item_code")
    private String dictItemCode;

    @Column(name = "dict_sort")
    private String dictSort;

    @Column(name = "dict_enable")
    private String dictEnable;

    @Column(name = "dict_memo")
    private String dictMemo;


    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    public String getDictItemName() {
        return dictItemName;
    }

    public void setDictItemName(String dictItemName) {
        this.dictItemName = dictItemName;
    }

    public String getDictItemCode() {
        return dictItemCode;
    }

    public void setDictItemCode(String dictItemCode) {
        this.dictItemCode = dictItemCode;
    }

    public String getDictSort() {
        return dictSort;
    }

    public void setDictSort(String dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictEnable() {
        return dictEnable;
    }

    public void setDictEnable(String dictEnable) {
        this.dictEnable = dictEnable;
    }

    public String getDictMemo() {
        return dictMemo;
    }

    public void setDictMemo(String dictMemo) {
        this.dictMemo = dictMemo;
    }
}