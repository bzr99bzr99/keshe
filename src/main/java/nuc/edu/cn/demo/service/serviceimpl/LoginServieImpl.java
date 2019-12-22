package nuc.edu.cn.demo.service.serviceimpl;

import nuc.edu.cn.demo.mapper.AdminMapper;
import nuc.edu.cn.demo.mapper.InhabitantMapper;
import nuc.edu.cn.demo.pojo.Admin;
import nuc.edu.cn.demo.pojo.Inhabitant;
import nuc.edu.cn.demo.pojo.LoginError;
import nuc.edu.cn.demo.service.LoginServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServieImpl implements LoginServie {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    InhabitantMapper inhabitantMapper;

    /**
     * Ajax检查登录账号密码
     * 1是管理员0是用户
     *
     * @return LoginError
     */
    @Override
    public LoginError logincheck(int id, String password, String attribute) {
        LoginError error = new LoginError();
        error.setNum(0);
        if ("1".equals(attribute)) {
            Admin admin = adminMapper.select(id);
            if (admin == null) {
                error.setNum(2);
                error.setIdError("yes");
                error.setPwdError("yes");
                return error;
            }
            if (admin.getId() != id) {
                error.setNum(error.getNum() + 1);
                error.setIdError("yes");
            }
            if (!admin.getPassword().equals(password)) {
                error.setNum(error.getNum() + 1);
                error.setPwdError("yes");
            }
            return error;
        } else if ("0".equals(attribute)) {
            //查询用户
            Inhabitant inhabitant = inhabitantMapper.select(id);
            if (inhabitant == null) {
                error.setNum(2);
                error.setIdError("yes");
                error.setPwdError("yes");
                return error;
            }
            if (inhabitant.getId() != id) {
                error.setNum(error.getNum() + 1);
                error.setIdError("yes");
            }
            if (!inhabitant.getPassword().equals(password)) {
                error.setNum(error.getNum() + 1);
                error.setPwdError("yes");
            }
            return error;
        }
        return error;
    }

    /**
     * 返回登陆住户信息
     * @param id
     * @return Inhabitant
     */
    @Override
    public Inhabitant selectInhabitant(int id) {
        return inhabitantMapper.select(id);
    }

    @Override
    public Admin selectAdmin(int id) {
        return adminMapper.select(id);
    }


}
