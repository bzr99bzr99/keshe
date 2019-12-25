package nuc.edu.cn.demo.mapper;

import nuc.edu.cn.demo.pojo.Inhabitant;
import nuc.edu.cn.demo.pojo.InhabitantAndPropertyfee;
import nuc.edu.cn.demo.pojo.InhabitantSon;
import nuc.edu.cn.demo.pojo.Propertyfee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PropertyfeeMapper {
    //查询全部缴费单信息
    public List<Propertyfee> selects();
    public Propertyfee select(int id);
    public int insert(Propertyfee propertyfee);
    public int delete(int id);
    public int update(Propertyfee propertyfee);
   // 通过缴费单id查找需缴费的业主
    public List<Inhabitant> findInhabitantById(int id);
    //查找所有的用户并返回为子类多一个flag属性
    public List<InhabitantSon> findAllInhabitant();
}
