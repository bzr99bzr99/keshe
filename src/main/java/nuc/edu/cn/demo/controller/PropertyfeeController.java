package nuc.edu.cn.demo.controller;

import nuc.edu.cn.demo.mapper.CostMapper;
import nuc.edu.cn.demo.pojo.Cost;
import nuc.edu.cn.demo.pojo.InhabitantSon;
import nuc.edu.cn.demo.pojo.Propertyfee;
import nuc.edu.cn.demo.service.CostService;
import nuc.edu.cn.demo.service.PropertyfeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/propertyfee")
@Controller
public class PropertyfeeController {
    @Autowired
    PropertyfeeService propertyfeeService;

    @Autowired
    CostService costService;

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
    public String selects(int id, Model model, HttpSession session) {
        //物业表服务处理数据
        session.setAttribute("inhabitants", propertyfeeService.flagInhabitant(id));
        //返回处理的物业表id
        model.addAttribute("pro_id", id);
        return "inhabitant_inform";
    }

    @RequestMapping("/addd")
    @ResponseBody
    public int[] addd(int[] checkbox, int propertyfee_id, HttpSession session) {
        List<InhabitantSon> inhabitantSons = (List<InhabitantSon>) session.getAttribute("inhabitants");
        int j = 0;
        int count = checkbox.length;
        for (int i = 0;i < inhabitantSons.size();i++){
            if (j<count&&inhabitantSons.get(i).getId()==checkbox[j]){
                if (inhabitantSons.get(i).getFlag()==0){
                    costService.insert(checkbox[j],propertyfee_id);
                }
                j++;
            }else if (inhabitantSons.get(i).getFlag()==1){
                costService.delete(inhabitantSons.get(i).getId(),propertyfee_id);
            }
        }
        return checkbox;
    }
}
