package nuc.edu.cn.demo.service.serviceimpl;

import nuc.edu.cn.demo.mapper.InhabitantMapper;
import nuc.edu.cn.demo.pojo.Inhabitant;
import nuc.edu.cn.demo.service.InhabitantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InhabitantServiceImpl implements InhabitantService {
    @Autowired
    InhabitantMapper inhabitantMapper;

    /**
     * @return List<Inhabitant>所有用户信息
     */
    @Override
    public List<Inhabitant> allInhabitant() {
        return inhabitantMapper.selectall();
    }

    /**
     * 模糊查询住户信息
     *
     * @param name
     * @return List<Inhabitant>
     */
    @Override
    public List<Inhabitant> likeInhabitantByName(String name) {
        return inhabitantMapper.likeInhabitantByName(name);
    }

    /**
     *根据id查询住户信息
     * @param id
     * @return Inhabitant
     */
    @Override
    public Inhabitant selectInhabitantById(int id) {
        return inhabitantMapper.select(id);
    }

    @Override
    public int updateInhabitant(Inhabitant inhabitant) {
        return inhabitantMapper.updateInhabitant(inhabitant);
    }

    @Override
    public int deleteInhabitant(int id) {
        return inhabitantMapper.deleteInhabitant(id);
    }

    @Override
    public int insertInhabitant(Inhabitant inhabitant) {
        return inhabitantMapper.insertInhabitant(inhabitant);
    }
}
