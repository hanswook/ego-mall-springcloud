package com.ego.service;


import com.ego.pojo.SUser;

import java.util.List;

public interface SUserService {

    void saveUser(SUser sUser);

    SUser queryUserById(Integer id);

    List<SUser> queryUserList(SUser user, Integer page, int pageSize);

}
