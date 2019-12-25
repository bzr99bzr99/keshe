package nuc.edu.cn.demo.controller;

import nuc.edu.cn.demo.pojo.Propertyfee;
import nuc.edu.cn.demo.service.PropertyfeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/propertyfee")
@Controller
public class PropertyfeeController {
    @Autowired
    PropertyfeeService propertyfeeService;

    /**
     * 查询所有的物业单信息并返回至物业表管理页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/selects")
    public String selects(Model model) {
        model.addAttribute("propertyfees", propertyfeeService.selects());
        return "admin_propertycosts";
    }

    @RequestMapping("/select")
    @ResponseBody
    public Propertyfee select(int id) {
        return propertyfeeService.select(id);
    }

    @RequestMapping("/delete")
    public String delete(int id) {
        propertyfeeService.delete(id);
        return "redirect:selects";
    }

    @RequestMapping("/update")
    public String update(Propertyfee propertyfee) {
        propertyfeeService.update(propertyfee);
        return "redirect:selects";
    }

    @RequestMapping("/insert")
    public String insert(Propertyfee propertyfee) {
        propertyfeeService.insert(propertyfee);
        return "redirect:selects";
    }

    @RequestMapping("/add")
    public String add(int id, Model model) {
        model.addAttribute("propertyfee_id", id);
        return "cost_inhabitant";
    }

    /**
     * 物业费需缴人员添加
     * 先查询该物业表待缴费人员信息
     * 查询全部人员信息
     * 待缴人员与全部人员信息比较改变flag信息  1是待缴 0是无关
     * 返回全部信息
     */
    @RequestMapping("/selectinhabitants")
    public String selects(int id, Model model) {
        //物业表服务处理数据
        model.addAttribute("inhabitants",propertyfeeService.flagInhabitant(id));
        return "inhabitant_inform";
    }
}
