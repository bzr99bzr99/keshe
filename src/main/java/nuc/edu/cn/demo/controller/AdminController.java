package nuc.edu.cn.demo.controller;

import nuc.edu.cn.demo.pojo.Inhabitant;
import nuc.edu.cn.demo.service.AdminService;
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
            if (i <= 14) {
                list.add(lists.get(i));
            }
        }
        session.setAttribute("nowpage", 1);
        model.addAttribute("inhabitants", list);
        model.addAttribute("pagenum", lists.size() / 15 + 1);
        return "admin_inhabitants";
    }

    //查询该住户信息并返回到修改页面
    @RequestMapping("/toupdate")
    public String toupdate(int id, Model model) {
        adminService.getInhabitant(id);
        model.addAttribute("user",adminService.getInhabitant(id));
        return "admin_inhabitant_update";
    }
}
