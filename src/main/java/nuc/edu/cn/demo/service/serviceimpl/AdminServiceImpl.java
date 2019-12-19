package nuc.edu.cn.demo.service.serviceimpl;

import nuc.edu.cn.demo.mapper.AdminMapper;
import nuc.edu.cn.demo.mapper.InhabitantMapper;
import nuc.edu.cn.demo.pojo.Inhabitant;
import nuc.edu.cn.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private InhabitantMapper inhabitantMapper;

    /**
     * 查询所有住户信息
     * @return 全部住户信息
     */
    @Override
    public List<Inhabitant> getInhabitants() {
        return inhabitantMapper.selectall();
    }

    @Override
    public Inhabitant getInhabitant(int id) {
        return inhabitantMapper.select(id);
    }
}
