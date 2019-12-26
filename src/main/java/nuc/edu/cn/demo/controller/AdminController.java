package nuc.edu.cn.demo.controller;

import nuc.edu.cn.demo.pojo.Admin;
import nuc.edu.cn.demo.pojo.Inhabitant;
import nuc.edu.cn.demo.service.AdminService;
import nuc.edu.cn.demo.service.InhabitantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private InhabitantService inhabitantService;

    /**
     * 查看所有住户信息
     *
     * @param model
     * @return 返回到管理员查看页面
     */
    @RequestMapping("/inhabitants")
    public String getInhabitant(Model model, HttpSession session) {
        List<Inhabitant> lists = adminService.getInhabitants();
        List<Inhabitant> list = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            if (i < 10) {
                list.add(lists.get(i));
            }
        }
        session.setAttribute("nowpage", 1);
        model.addAttribute("inhabitants", list);
        session.setAttribute("pagenum", lists.size() / 10 + 1);
        return "admin_inhabitants";
    }

    //查询该住户信息并返回到修改页面
    @RequestMapping("/toupdate")
    public String toupdate(int id, Model model) {
        adminService.getInhabitant(id);
        model.addAttribute("user", adminService.getInhabitant(id));
        return "admin_inhabitant_update";
    }

    //页面跳转
    @RequestMapping("/topage")
    public String topage(int topage, HttpSession session, Model model) {
        int pagenum = (int) session.getAttribute("pagenum");
        if (topage < 1) {
            topage = 1;
        }
        if (topage > pagenum) {
            topage = pagenum;
        }
        List<Inhabitant> lists = adminService.getInhabitants();
        List<Inhabitant> list = new ArrayList<>();
        for (int i = (topage - 1) * 10; i < lists.size(); i++) {
            if (i < topage * 10) {
                list.add(lists.get(i));
            }
        }
        session.setAttribute("nowpage", topage);
        model.addAttribute("inhabitants", list);
        return "admin_inhabitants";
    }

    /**
     * ajax更改管理员信息
     */
    @RequestMapping("/update")
    @ResponseBody
    public int update(Admin admin) {
        return adminService.update(admin);
    }

    /**
     * 返回管理员主页
     *
     * @return
     */
    @RequestMapping("/toindex")
    public String toindex() {
        return "admin_success";
    }

    @RequestMapping("/insertInhabitant")
    public String insertInhabitant(Inhabitant inhabitant) {
        inhabitantService.insertInhabitant(inhabitant);
        return "redirect:inhabitants";
    }
}
