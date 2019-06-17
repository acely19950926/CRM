package com.itheima.web.action;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/")
@Results({
        @Result(location = "/jsp/success.jsp", name = "success", type = "redirect"),
        @Result(location = "/login.jsp", name = "loginError"),//不可以使用重定向,如果使用数据丢失
        @Result(location = "/index.jsp", name = "index", type = "redirect"),
        @Result(location = "/login.jsp", name = "login", type = "redirect"),
})
public class UserAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    @Autowired
    private UserService userService;

    /**
     * 用户的注册功能
     *
     * @return
     * @throws Exception
     */
    @Action("userAction_save")
    public String save() throws Exception {
        userService.save(user);
        return "success";
    }

    /**
     * 用户的登录功能 login()
     *
     * @return 成功返回Index 失败返回loginError
     */
    @Action("userAction_login")
    public String login() throws Exception {
        User loginUser = userService.findUserByNameAndPwd(user.getUserCode(), user.getUserPassword());
        if (loginUser != null) {
            //表示登录成功
            ActionContext.getContext().getSession().put("user", loginUser);
            return "index";
        }
        this.addFieldError("msg", "用户名或密码错误");
        return "loginError";
    }


    /**
     * 用户的登出功能  loginOut
     *
     * @return 返回login
     * @throws Exception
     */
    @Action("userAction_loginOut")
    public String loginOut() throws Exception {
        ActionContext.getContext().getSession().remove("user");
        return "login";
    }


    /**
     * 用户修改密码的功能 edit()
     *
     * @return
     * @throws Exception
     */
    @Action("userAction_edit")
    public String edit() throws Exception {
        //1、必须先获取用户的数据 页面是否需要传入数据
        //1.1 获取原来数据 不需要传入 因为session就有
        User oldUser = (User) ActionContext.getContext().getSession().get("user");
        //1.2 修改后的数据 需要得到 新修改的密码即可（需要不需要传入 已经被封装到模型驱动中 从模型驱动中获取即可），然后覆盖旧密码
        oldUser.setUserPassword(user.getUserPassword());
        //1.3 调用service修改数据即可
        userService.update(oldUser);
        //1.4 需要清空session中的用户数据
        ActionContext.getContext().getSession().remove("user");
        return SUCCESS;
    }

    @Override
    public User getModel() {
        return user;
    }
}
