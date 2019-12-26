package nuc.edu.cn.demo.service.serviceimpl;

import nuc.edu.cn.demo.mapper.CostMapper;
import nuc.edu.cn.demo.pojo.Cost;
import nuc.edu.cn.demo.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostServiceImpl implements CostService {
    @Autowired
    CostMapper costMapper;

    @Override
    public int insert(int inhabitant_id,int propertyfee_id) {
        Cost cost = new Cost();
        cost.setInhabitant_id(inhabitant_id);
        cost.setPropertyfee_id(propertyfee_id);
        return costMapper.insert(cost);
    }

    @Override
    public int delete(int inhabitant_id,int propertyfee_id) {
        Cost cost = new Cost();
        cost.setInhabitant_id(inhabitant_id);
        cost.setPropertyfee_id(propertyfee_id);
        return costMapper.delete(cost);
    }
}
