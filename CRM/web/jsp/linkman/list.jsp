<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <TITLE>联系人列表</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
    <LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
          rel=stylesheet>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //获得下拉框 获得下拉框中所有的option
            //其中一个Value值 如果跟请求过去的所属客户Id相等 我们需要添加selected属性
            <%--$("#customerId option[value='${customer.custId}']").prop("selected", true);--%>
            $("#customerId option[value='${customer.custId}']").prop("selected", true);
        })

        /**
         * 联系人删除提示
         * @param lkmId
         */
        function deleteLinkman(lkmId) {
            var flag = confirm("是否确认删除？");
            if (flag) {
                location.href = "${pageContext.request.contextPath}/linkmanAction_deleteByLkmId?lkmId=" + lkmId;
            }
        }
    </script>
    <SCRIPT language=javascript>
        function to_page(page) {
            if (page) {
                $("#page").val(page);
            }
            document.customerForm.submit();
        }
    </SCRIPT>

    <META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<FORM id="linkmanForm" name="customerForm"
      action="${pageContext.request.contextPath }/linkmanAction_findByCondition"
      method=post>

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
            <TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
                    src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
            <TD vAlign=top width="100%" bgColor=#ffffff>
                <TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
                    <TR>
                        <TD class=manageHead>当前位置：联系人管理 &gt; 联系人列表</TD>
                    </TR>
                    <TR>
                        <TD height=2></TD>
                    </TR>
                </TABLE>
                <TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
                       width="100%" align=center border=0>
                    <TBODY>
                    <TR>
                        <TD height=25>
                            <TABLE cellSpacing=0 cellPadding=2 border=0>
                                <TBODY>
                                <TR>
                                    <TD>联系人名称：</TD>
                                    <TD><INPUT class=textbox id=sChannel2
                                               style="WIDTH: 80px" maxLength=50 name="lkmName" value="${lkmName}"></TD>
                                    <td>性别：</td>
                                    <td>
                                        <select name="lkmGender">
                                            <option value="">--请选择--</option>
                                            <option value="1" ${lkmGender == "1" ? "selected":""}>男</option>
                                            <option value="2" ${lkmGender == "2" ? "selected":""}>女</option>
                                        </select>
                                        <!--页码的隐藏域-->
                                        <input type="hidden" name="pageNumber" value="1" id="pageNumberId">
                                    </td>
                                    <td>所属客户：</td>
                                    <td>
                                        <select id="customerId" name="customer.custId" style="width: 180px">
                                            <option value="">--请选择--</option>
                                            <c:forEach items="${customerList}" var="tempCustomer">
                                                <%--<option value="${tempCustomer.custId}" ${tempCustomer.custId == customer.custId?"selected":""}>${tempCustomer.custName}</option>--%>
                                                <option value="${tempCustomer.custId}">${tempCustomer.custName}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <TD><INPUT class=button id=sButton2 type=submit
                                               value=" 筛选 " name=sButton2></TD>
                                </TR>
                                </TBODY>
                            </TABLE>
                        </TD>
                    </TR>

                    <TR>
                        <TD>
                            <TABLE id=grid
                                   style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
                                   cellSpacing=1 cellPadding=2 rules=all border=0>
                                <TBODY>
                                <TR style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
                                    <TD>联系人名称</TD>
                                    <TD>性别</TD>
                                    <TD>办公电话</TD>
                                    <TD>手机</TD>
                                    <td>所属客户</td>
                                    <TD>操作</TD>
                                </TR>

                                <c:forEach items="${pageBean.data}" var="tempLinkman">
                                    <TR style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
                                        <TD>${tempLinkman.lkmName}</TD>
                                        <TD>${tempLinkman.lkmGender == 1?"男":"女"}</TD>
                                        <TD>${tempLinkman.lkmPhone}</TD>
                                        <TD>${tempLinkman.lkmMobile}</TD>
                                        <TD>${tempLinkman.customer.custName}</TD>
                                        <TD>
                                            <a href="${pageContext.request.contextPath}/linkmanAction_editUI?lkmId=${tempLinkman.lkmId}">修改</a>
                                            &nbsp;&nbsp;
                                            <a href="javascript:void(0)"
                                               onclick="deleteLinkman('${tempLinkman.lkmId}')">删除</a>
                                        </TD>
                                    </TR>
                                </c:forEach>
                                </TBODY>
                            </TABLE>
                        </TD>
                    </TR>

                    <TR>
                        <TD><SPAN id=pagelink>
											<DIV style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right">

												共[<B>${pageBean.totalRecord}</B>]条记录,[<B>${pageBean.pageNumber}</B>]页
<%--												[<A href="${pageContext.request.contextPath}/linkmanAction_findByCondition?pageNumber=${pageBean.pageNumber-1}">前一页</A>]--%>
                                                [<A href="javascript:void(0)"
                                                    onclick="goToPage(${pageBean.pageNumber - 1})">前一页</A>]
												<B>
                                                    <c:forEach begin="1" end="${pageBean.totalPage}" step="1" var="num">
                                                        <a href="javascript:void(0)" onclick="goToPage(${num})">
                                                            <font ${num == pageBean.pageNumber? "color='red'":''}> ${num}</font>
                                                        </a>
                                                    </c:forEach>
                                                </B>
												[<a href="javascript:void(0)"
                                                    onclick="goToPage(${pageBean.pageNumber + 1})" name="nextPage">后一页</a>]
												
											</DIV>
									</SPAN></TD>
                    </TR>
                    <script>
                        function goToPage(goPage) {

                            if (goPage < 1) {
                                $("#nextPage").attr("disabled","true");
                                return;
                            }
                            //获取最大页数
                            var totalPage = '${pageBean.totalPage}';
                            if (goPage > totalPage) {
                                // alert("当前已经是最后一页了，不能下一页了");
                                $("#nextPage").attr("disabled","true");
                                return;
                            }
                            //函数的参数为 将要访问的页码 只需要条件即可
                            //而条件在表单当中 我如果将页码也放入了表单 只需要提交表单 那条件也有了 页码也有了
                            //获得隐藏域 并赋值即可
                            $("#pageNumberId").val(goPage);
                            //提交表单 先获得表单 在提交即可
                            $("#linkmanForm").submit();
                        }
                    </script>
                    </TBODY>
                </TABLE>
            </TD>
            <TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
                    src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
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
