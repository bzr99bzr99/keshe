package nuc.edu.cn.demo.controller;

import nuc.edu.cn.demo.pojo.InhabitantAndPropertyfee;
import nuc.edu.cn.demo.pojo.LoginError;
import nuc.edu.cn.demo.service.LoginServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequestMapping("/login")
@Controller
public class LoginController {
    @Autowired
    LoginServie loginServie;

    /**
     * Ajax登录检查
     *
     * @param id
     * @param password
     * @param attribute 登录人员属性
     * @return LoginError 错误信息
     */
    @RequestMapping("/loginAjax")
    @ResponseBody
    public LoginError logincheck(int id, String password, String attribute) {
        return loginServie.logincheck(id, password, attribute);
    }

    /**
     * @param id
     * @param password
     * @param attribute
     * @param model
     * @return 登录成功主页面
     */
    @RequestMapping("/loginsuccess")
    public ModelAndView loginsuccess(int id, String password, String attribute, ModelAndView model, HttpSession session) {
        if ("1".equals(attribute)) {
            session.setAttribute("attribute", "管理员");//登陆状态
            session.setAttribute("user", loginServie.selectAdmin(id));
            model.setViewName("admin_success");
        }
        if ("0".equals(attribute)) {
            //登陆状态
            session.setAttribute("attribute", "住户");
            //住户id
            session.setAttribute("id", loginServie.selectInhabitant(id).getId());
            session.setAttribute("user", loginServie.selectInhabitant(id));
            InhabitantAndPropertyfee inhabitantAndPropertyfee= loginServie.count(id);
            if(inhabitantAndPropertyfee.getCount()!=0){
                session.setAttribute("count", inhabitantAndPropertyfee.getPropertyfees().size());
                session.setAttribute("warn", inhabitantAndPropertyfee.getPropertyfees());
            }
            model.setViewName("login_success");
        }
        return model;
    }

    /**
     * 退出
     *
     * @param session
     * @return
     */
    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("user");
        session.removeAttribute("attribute");
        session.removeAttribute("id");
        session.removeAttribute("user");
        session.removeAttribute("nowpage");
        session.removeAttribute("pagenum");
        session.removeAttribute("count");
        session.removeAttribute("warn");
        session.removeAttribute("inhabitants");
        return "index";
    }
}
