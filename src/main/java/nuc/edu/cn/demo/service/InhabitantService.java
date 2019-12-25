package nuc.edu.cn.demo.service;

import nuc.edu.cn.demo.pojo.Inhabitant;
import nuc.edu.cn.demo.pojo.InhabitantAndPropertyfee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InhabitantService {
    public List<Inhabitant> allInhabitant();//查询所有住户信息
    public List<Inhabitant> likeInhabitantByName(String name);//模糊查询住户
    public Inhabitant selectInhabitantById(int id);//根据id查询用户信息
    public int updateInhabitant(Inhabitant inhabitant);
    public int deleteInhabitant(int id);
    public int insertInhabitant(Inhabitant inhabitant);
    public InhabitantAndPropertyfee findById(int id);
}
