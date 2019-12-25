package nuc.edu.cn.demo.mapper;

import nuc.edu.cn.demo.pojo.Inhabitant;
import nuc.edu.cn.demo.pojo.InhabitantAndPropertyfee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InhabitantMapper {
    public Inhabitant select(int id);
    public List<Inhabitant> selectall();
    public List<Inhabitant> likeInhabitantByName(String name);
    public int updateInhabitant(Inhabitant inhabitant);
    public int deleteInhabitant(int id);
    public int insertInhabitant(Inhabitant inhabitant);
    public InhabitantAndPropertyfee findById(int id);
}
