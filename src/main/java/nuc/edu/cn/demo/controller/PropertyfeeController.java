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
     * @param model
     * @return
     */
    @RequestMapping("/selects")
    public String selects(Model model) {
        model.addAttribute("propertyfees",propertyfeeService.selects());
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
}
