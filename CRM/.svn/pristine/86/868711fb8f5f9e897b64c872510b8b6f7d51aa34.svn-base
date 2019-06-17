<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/frameset.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <STYLE type=text/css>
        BODY {
            FONT-SIZE: 12px;
            COLOR: #ffffff;
            FONT-FAMILY: 宋体
        }

        TD {
            FONT-SIZE: 12px;
            COLOR: #ffffff;
            FONT-FAMILY: 宋体
        }
    </STYLE>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>


    <script>
        //校验表单修改
        function checkForm() {
            //校验表单内的数据
            var flag = true;    //如果有错误 我将flag置为false即可

            //1、当前用户：不允许修改用户名(将文本框置为readOnly【只读】属性) 需要显示用户名（从session获取即可）
            //2、获得用户输入的旧密码，要与原来的旧密码一致（session都有）

            var oldPwd = "${user.userPassword}";
            var inputOldPwd = $("#oldPassword").val();
            if (oldPwd != inputOldPwd) {
                alert("输入旧密码错误，请重新输入！")
                flag = false;
            }

            //3、新密码不能为null,并且确认密码必须与新密码一致
            var newPwd = $("#password").val();
            var oldPwd = $("#rePassword").val();

            if (newPwd.length == 0) {
                alert("新密码不能为空")
                flag = false;
            }

            if (newPwd != oldPwd) {
                alert("新密码与旧密码不一致，请重新输入！")
                flag = false;
            }
            return flag;
        }
    </script>

    <META content="MSHTML 6.00.6000.16809" name=GENERATOR>
</HEAD>
<BODY>
<FORM id=form1 name=form1 action="${pageContext.request.contextPath}/userAction_edit" onsubmit="return checkForm()"
      method=post>

    <DIV id=UpdatePanel1>
        <DIV id=div1
             style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>
        <DIV id=div2
             style="LEFT: 0px; POSITION: absolute; TOP: 0px; BACKGROUND-COLOR: #0066ff"></DIV>


        <DIV>&nbsp;&nbsp;</DIV>
        <DIV>
            <TABLE cellSpacing=0 cellPadding=0 width=900 align=center border=0>
                <TBODY>
                <TR>
                    <TD style="HEIGHT: 105px"><IMG src="images/login_1.gif" border=0></TD>
                </TR>
                <TR>
                    <TD background=images/timg3.jpg height=300>
                        <TABLE height=350 cellPadding=0 width=900 border=0>
                            <TBODY>
                            <TR>
                                <TD colSpan=2 height=35></TD>
                            </TR>
                            <TR>
                                <TD width=360></TD>
                                <TD>
                                    <TABLE cellSpacing=0 cellPadding=2 border=0>
                                        <TBODY>

                                        <TR>
                                            <TD style="HEIGHT: 28px" width=80>当前用户：</TD>
                                            <TD style="HEIGHT: 28px" width=150>
                                                <INPUT id="username" style="WIDTH: 130px" name="username"
                                                       value="${user.userCode}" readonly="readonly">
                                                <!-- 隐藏域提供uid -->
                                                <input type="hidden" name="uid" value="${user.userId}"/>
                                                <!-- 防止数据丢失 需要额外提供用户的名称 -->
                                                <input type="hidden" name="name" value="${user.userCode}"/>
                                            </TD>
                                        </TR>

                                        <TR>
                                            <TD style="HEIGHT: 28px" width=80>旧密码：</TD>
                                            <TD style="HEIGHT: 28px" width=150>
                                                <INPUT id="oldPassword" type=password style="WIDTH: 130px"
                                                       name="oldPassword">
                                            </TD>
                                        </TR>
                                        <TR>
                                            <TD style="HEIGHT: 28px">新密码：</TD>
                                            <TD style="HEIGHT: 28px">
                                                <INPUT id="password" style="WIDTH: 130px" type=password
                                                       name="userPassword">
                                            </TD>
                                        </TR>
                                        <TR>
                                            <TD style="HEIGHT: 28px">确认密码：</TD>
                                            <TD style="HEIGHT: 28px">
                                                <INPUT id="rePassword" style="WIDTH: 130px" type=password
                                                       name="rePassword">
                                            </TD>
                                        </TR>
                                        <TR>
                                        <TR>
                                            <TD style="HEIGHT: 18px"></TD>
                                            <TD style="HEIGHT: 18px"></TD>
                                        </TR>
                                        <TR>
                                            <TD style="HEIGHT: 28px" width=230 colspan="2">
                                                <font id="errorMsg" color="red"></font>
                                            </TD>
                                        </TR>
                                        <TR>
                                            <TD></TD>
                                            <TD>
                                                <INPUT id=btn
                                                       style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px"
                                                       type=image src="images/register_button.jpg" name=btn>
                                            </TD>
                                        </TR>
                                        </TBODY>
                                    </TABLE>
                                </TD>
                            </TR>
                            </TBODY>
                        </TABLE>
                    </TD>
                </TR>
                <TR>
                    <TD>
                        <IMG src="images/login_3.jpg" border=0>
                    </TD>
                </TR>
                </TBODY>
            </TABLE>
        </DIV>
    </DIV>

</FORM>
</BODY>
</HTML>

