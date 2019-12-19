package nuc.edu.cn.demo.service;

import nuc.edu.cn.demo.pojo.Inhabitant;
import nuc.edu.cn.demo.pojo.LoginError;
import org.springframework.stereotype.Service;

import java.util.List;
public interface LoginServie {
    public LoginError logincheck(int id,String password,String attribute);//AJax登录检查
    public Inhabitant selectInhabitant(int id);//查询登陆者信息
}
