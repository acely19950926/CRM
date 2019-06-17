<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>修改客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>

<script>
	$(function(){
		//sourceId  levelId  industryId
		//能不能获得到服务器给我传递的数据
		/* var levelStr = "${baseDictLevel.dictId}";
		var sourceStr = "${baseDictSource.dictId}";
		var industryStr = "${baseDictIndustry.dictId}";
		 */
		//下拉框已经有字典表的所有对应的数据
		//只需要给对应下拉框的option添加一个选中属性即可
		$("#sourceId option[value='${tempCustomer.baseDictSource.dictId}']").prop("selected" , true);
		$("#levelId option[value='${tempCustomer.baseDictLevel.dictId}']").prop("selected" , true);
		$("#industryId option[value='${tempCustomer.baseDictIndustry.dictId}']").prop("selected" , true);
		
	})
	
</script>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customerAction_edit"
		method=post>

		<input type="hidden" value="${tempCustomer.custId}">
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
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
						    
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custName" value="${tempCustomer.custName}">
								<input type="hidden" name="custId" value="${tempCustomer.custId}"/>
								
								</td> 
								<td>客户级别 ：</td>
								<td>
									<select id="levelId" name="baseDictLevel.dictId" style="WIDTH: 180px">
										<option value="">--请选择--</option>
										<c:forEach items="${baseDictLevelList}" var="baseDictLevel">
											<option value="${baseDictLevel.dictId}">${baseDictLevel.dictItemName}</option>
										</c:forEach>
									</select>
								</td>    
							</TR>
							
							<TR>
								
								<td>信息来源 ：</td>
								<td>
									<select id="sourceId" name="baseDictSource.dictId" style="WIDTH: 180px">
										<option value="">--请选择--</option>
										<c:forEach items="${baseDictSourceList}" var="baseDictSource">
											<option value="${baseDictSource.dictId}">${baseDictSource.dictItemName}</option>
										</c:forEach>
									</select>
								</td>
								<td>所属行业 ：</td>
								<td>
									<select id="industryId" name="baseDictIndustry.dictId" style="WIDTH: 180px">
										<option value="">--请选择--</option>
										<c:forEach items="${baseDictIndustryList}" var="baseDictIndustry">
											<option value="${baseDictIndustry.dictId}">${baseDictIndustry.dictItemName}</option>
										</c:forEach>
									</select>
								</td>
							</TR>
							
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custPhone" value="${tempCustomer.custPhone}">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custMobile" value="${tempCustomer.custMobile}">
								</td>
							</TR>
							
							
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
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
