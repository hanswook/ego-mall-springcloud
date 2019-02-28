package com.sbc.egoserviceimpl.impl;

import com.ego.pojo.SUser;
import com.ego.service.SUserService;
import com.github.pagehelper.PageHelper;
import com.sbc.egoserviceimpl.mapper.SUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements SUserService {

    @Autowired
    private SUserMapper sUserMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(SUser sUser) {
        sUserMapper.insert(sUser);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SUser queryUserById(Integer id) {
        System.out.println("id:"+id);
        return sUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SUser> queryUserList(SUser user, Integer page, int pageSize) {

        PageHelper.startPage(page, pageSize);

        Example example = new Example(SUser.class);
        List<SUser> userList = sUserMapper.selectByExample(example);

        return userList;
    }
}
