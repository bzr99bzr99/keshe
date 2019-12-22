package nuc.edu.cn.demo.mapper;

import nuc.edu.cn.demo.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    public Admin select(int id);
    public int update(Admin admin);
}
