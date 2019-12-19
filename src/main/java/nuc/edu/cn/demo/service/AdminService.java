package nuc.edu.cn.demo.service;

import nuc.edu.cn.demo.mapper.AdminMapper;
import nuc.edu.cn.demo.pojo.Inhabitant;

import java.util.List;

public interface AdminService {
    //查询所有用户的信息
    public List<Inhabitant> getInhabitants();
    //查询一个住户的信息
    public Inhabitant getInhabitant(int id);
}
