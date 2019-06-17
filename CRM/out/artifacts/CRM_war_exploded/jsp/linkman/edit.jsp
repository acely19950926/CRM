﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE>修改联系人</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<script>
    $(function () {
        // alert();
        $("#customerId option[value='${tempLinkman.customer.custId}']").prop("selected", true);
        //先获取性别的单选按钮
        //还需要 值等于后台联系人的性别 单选按钮是checked属性被选中 而下拉框是selected属性被选中
        $("input[name='lkmGender'][value='${tempLinkman.lkmGender}']").prop("checked", true);
    })
</script>
<BODY>
<FORM id=form1 name=form1
      action="${pageContext.request.contextPath }/linkmanAction_edit"
      method=post>
    <input type="hidden" name="lkmId" value="${tempLinkman.lkmId}">
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
                              border=0></TD>
            <TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
                height=20></TD>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
                              border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
                    src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
            <TD vAlign=top width="100%" bgColor=#ffffff>
                <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
                    <TR>
                        <TD class=manageHead>当前位置：联系人管理 &gt; 修改联系人</TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>
                <TABLE cellSpacing=0 cellPadding=5 border=0>
                    <tr>
                        <td>所属客户：</td>
                        <td colspan="3">
                            <select id="customerId" name="customer.custId" style="WIDTH: 180px">
                                <c:forEach items="${customerList}" var="tempCustomer">
                                    <option value="${tempCustomer.custId}">${tempCustomer.custName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <TR>
                        <td>联系人名称：</td>
                        <td>
                            <INPUT class=textbox id=sChannel2
                                   style="WIDTH: 180px" maxLength=50 name="lkmName" value="${tempLinkman.lkmName}">
                        </td>
                        <td>联系人性别：</td>
                        <td>
                            <input type="radio" value="1" name="lkmGender">男
                            <input type="radio" value="2" name="lkmGender">女
                        </td>
                    </TR>
                    <TR>
                        <td>联系人办公电话 ：</td>
                        <td>
                            <INPUT class=textbox id=sChannel2
                                   style="WIDTH: 180px" maxLength=50 name="lkmPhone" value="${tempLinkman.lkmPhone}">
                        </td>
                        <td>联系人手机 ：</td>
                        <td>
                            <INPUT class=textbox id=sChannel2
                                   style="WIDTH: 180px" maxLength=50 name="lkmMobile" value="${tempLinkman.lkmMobile}">
                        </td>
                    </TR>
                    <tr>
                        <td rowspan=2>
                            <INPUT class=button id=sButton2 type=submit
                                   value="保存 " name=sButton2>
                        </td>
                    </tr>
                </TABLE>


            </TD>
            <TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
                <IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
        <TBODY>
        <TR>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
                              border=0></TD>
            <TD align=middle width="100%"
                background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
            <TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
                              border=0></TD>
        </TR>
        </TBODY>
    </TABLE>
</FORM>
</BODY>
</HTML>
