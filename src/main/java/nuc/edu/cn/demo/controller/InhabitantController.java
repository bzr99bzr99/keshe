package nuc.edu.cn.demo.controller;

import nuc.edu.cn.demo.pojo.Inhabitant;
import nuc.edu.cn.demo.service.InhabitantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/inhabitant")
@Controller
public class InhabitantController {
    @Autowired
    InhabitantService inhabitantService;

    /**
     * 返回到主页
     *
     * @return
     */
    @RequestMapping("/toindex")
    public String toindex() {
        return "login_success";
    }

    /**
     * 查询全部住户信息
     *
     * @param model
     * @return List 小于等于15个住户的List和页面数量countpage
     */
    @RequestMapping("/inhabitants")
    public String findallinhabitant(Model model, HttpSession session) {
        List<Inhabitant> lists = inhabitantService.allInhabitant();
        List<Inhabitant> list = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            if (i <= 14) {
                list.add(lists.get(i));
            }
        }
        session.setAttribute("nowpage", 1);
        model.addAttribute("inhabitants", list);
        model.addAttribute("pagenum", lists.size() / 15 + 1);
        return "custom";
    }

    /**
     * ajax按键请求信息
     *
     * @param name
     * @return List<Inhabitant> 所有符合的住户json信息
     */
    @RequestMapping("/ajaxquery")
    @ResponseBody
    public List<Inhabitant> ajaxQuery(String name, HttpSession session) {
        List<Inhabitant> lists = inhabitantService.likeInhabitantByName(name);
        List<Inhabitant> list = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            if (i <= 14) {
                list.add(lists.get(i));
            }
        }
        return list;
    }

    //页面跳转一页最多15个数据
    @RequestMapping("/toinhabitant")
    public String toinhabitant() {
        return "custom";
    }

    /**
     * ajax 发送请求去第gopage页
     *
     * @param gopage
     * @param session
     * @return 对应页面的数据 List<Inhabitant>
     */
    @RequestMapping("/gopage")
    @ResponseBody
    public List<Inhabitant> gopage(int gopage, HttpSession session) {
        List<Inhabitant> lists = inhabitantService.allInhabitant();
        List<Inhabitant> list = new ArrayList<>();
        for (int i = (gopage - 1) * 15; i < lists.size(); i++) {
            if (i <= gopage * 15 - 1) {
                list.add(lists.get(i));
            }
        }
        session.setAttribute("nowpage", gopage);
        return list;
    }

    /**
     * @param session 能获取当前的页面是那一夜
     * @return 对应的页面
     */
    @RequestMapping("/pripage")
    @ResponseBody
    public List<Inhabitant> pripage(HttpSession session) {
        int nowpage = (int) session.getAttribute("nowpage");
        List<Inhabitant> lists = inhabitantService.allInhabitant();
        List<Inhabitant> list = new ArrayList<>();
        if (nowpage <= 1) {
            for (int i = 0; i < lists.size(); i++) {
                if (i <= 14) {
                    list.add(lists.get(i));
                }
            }
            return list;
        } else {
            for (int i = (nowpage - 2) * 15; i < lists.size(); i++) {
                if (i < (nowpage - 1) * 15) {
                    list.add(lists.get(i));
                }
            }
            session.setAttribute("nowpage", nowpage - 1);
            return list;
        }
    }

    /**
     * ajax下一页
     *
     * @return下一页信息
     */
    @RequestMapping("/nextpage")
    @ResponseBody
    public List<Inhabitant> nextpage(HttpSession session) {
        int nowpage = (int) session.getAttribute("nowpage");
        List<Inhabitant> lists = inhabitantService.allInhabitant();
        List<Inhabitant> list = new ArrayList<>();
        //页面数量
        int pagenum = lists.size() / 15;
        if (nowpage >= pagenum + 1) {
            for (int i = (nowpage - 1) * 15; i < lists.size(); i++) {
                if (i < nowpage * 15) {
                    list.add(lists.get(i));
                }
            }
            return list;
        } else {
            for (int i = (nowpage) * 15; i < lists.size(); i++) {
                if (i < (nowpage + 1) * 15) {
                    list.add(lists.get(i));
                }
            }
            session.setAttribute("nowpage", nowpage + 1);
            return list;
        }
    }

    /**
     * ajax发送请求修改住户信息
     *
     * @param inhabitant
     * @return
     */
    @RequestMapping("/updateinhabitant")
    @ResponseBody
    public int updateInhabitant(Inhabitant inhabitant) {
        return inhabitantService.updateInhabitant(inhabitant);
    }

    /**
     * 通过id删除住户信息   可用
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteinhabitant")
    public String deleteInhabitant(int id) {
        inhabitantService.deleteInhabitant(id);
        return "redirect:/admin/inhabitants";
    }

    /**
     * 添加用户信息
     *
     * @param inhabitant
     * @return
     */
    @RequestMapping("/insertinhabitant")
    @ResponseBody
    public int insertInhabitant(Inhabitant inhabitant) {
        return inhabitantService.insertInhabitant(inhabitant);
    }

    /**
     * 管理员查询一个住户信息
     * @param query
     * @param model
     * @return
     */
    @RequestMapping("selectone")
    public String selectone(String query,Model model) {
        model.addAttribute("inhabitants",inhabitantService.likeInhabitantByName(query));
        return "admin_inhabitants";
    }

}
