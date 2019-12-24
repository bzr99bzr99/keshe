package nuc.edu.cn.demo.mapper;

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
}
