package nuc.edu.cn.demo.mapper;

import nuc.edu.cn.demo.pojo.Cost;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CostMapper {
    public int insert(Cost cost);
    public int delete(Cost cost);
}
