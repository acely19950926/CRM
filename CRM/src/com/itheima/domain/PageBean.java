package com.itheima.domain;

import java.util.List;

public class PageBean<T> {
    /**
     * 2个传
     * 2个算
     * 2个查
     * 2个动态条
     */
    private int pageNumber; //当前页
    private int pageSize;   //每页显示个数

    private int startIndex; //开始索引
    private int totalPage;  //总页数

    private int totalRecord;//总记录数
    private List<T> data;

    private int start;  //遍历开始
    private int end;    //遍历结束

    public PageBean(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        //开始索引 = （当前页 -1） * pageSize
        startIndex = (pageNumber - 1) * pageSize;
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRecord() {
        //总记录数/每页显示个数
        System.out.println("********************");
        System.out.println("总记录数：" + totalRecord);
        System.out.println("总页数：" + pageSize);
        System.out.println("********************");

        if ((totalRecord % pageSize) == 0) {
            totalPage = totalRecord / pageSize;
            System.err.println("能整除：" + totalPage);
        } else {
            totalPage = (totalRecord / pageSize) + 1;
            System.err.println("不能整除：" + totalPage);
        }
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
