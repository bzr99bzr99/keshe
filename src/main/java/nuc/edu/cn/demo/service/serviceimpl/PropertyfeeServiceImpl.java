package nuc.edu.cn.demo.service.serviceimpl;

import nuc.edu.cn.demo.mapper.PropertyfeeMapper;
import nuc.edu.cn.demo.pojo.Inhabitant;
import nuc.edu.cn.demo.pojo.InhabitantSon;
import nuc.edu.cn.demo.pojo.Propertyfee;
import nuc.edu.cn.demo.service.InhabitantService;
import nuc.edu.cn.demo.service.PropertyfeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyfeeServiceImpl implements PropertyfeeService {
    @Autowired
    PropertyfeeMapper propertyfeeMapper;

    @Override
    public List<Propertyfee> selects() {
        return propertyfeeMapper.selects();
    }

    @Override
    public Propertyfee select(int id) {
        return propertyfeeMapper.select(id);
    }

    @Override
    public int delete(int id) {
        return propertyfeeMapper.delete(id);
    }

    @Override
    public int insert(Propertyfee propertyfee) {
        return propertyfeeMapper.insert(propertyfee);
    }

    @Override
    public int update(Propertyfee propertyfee) {
        return propertyfeeMapper.update(propertyfee);
    }

    @Override
    public List<Inhabitant> findHabitantById(int id) {
        return propertyfeeMapper.findInhabitantById(id);
    }

    @Override
    public List<InhabitantSon> flagInhabitant(int id) {
        List<Inhabitant> inhabitants = propertyfeeMapper.findInhabitantById(id);
        List<InhabitantSon> inhabitantSons = propertyfeeMapper.findAllInhabitant();
        int j = 0;
        for(int i = 0;i < inhabitantSons.size();i++){
            if (j >= inhabitants.size()){
                break;
            }
            if(inhabitantSons.get(i).getId()==inhabitants.get(j).getId()){
                inhabitantSons.get(i).setFlag(1);
                j++;
            }
        }
        return inhabitantSons;
    }
}
