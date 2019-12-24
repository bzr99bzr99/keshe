package nuc.edu.cn.demo.service.serviceimpl;

import nuc.edu.cn.demo.mapper.PropertyfeeMapper;
import nuc.edu.cn.demo.pojo.Propertyfee;
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
}
