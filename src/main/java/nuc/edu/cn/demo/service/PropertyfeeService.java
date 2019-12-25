package nuc.edu.cn.demo.service;


import nuc.edu.cn.demo.pojo.Inhabitant;
import nuc.edu.cn.demo.pojo.InhabitantSon;
import nuc.edu.cn.demo.pojo.Propertyfee;

import java.util.List;

public interface PropertyfeeService {
    public List<Propertyfee> selects();

    public Propertyfee select(int id);

    public int delete(int id);

    public int insert(Propertyfee propertyfee);

    public int update(Propertyfee propertyfee);
    //通过物业表id查询业主
    public List<Inhabitant> findHabitantById(int id);

    public List<InhabitantSon> flagInhabitant(int id);
}
