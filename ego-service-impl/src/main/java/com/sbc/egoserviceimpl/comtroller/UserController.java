package com.sbc.egoserviceimpl.comtroller;


import com.ego.pojo.HansJSONResult;
import com.ego.pojo.SUser;
import com.ego.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    SUserService sUserService;

    @RequestMapping("/queryUserListPaged")
    public HansJSONResult queryUserListPaged(Integer page) {
        SUser user = new SUser();
        if (null == page) {
            page = 1;
        }

        int pageSize = 10;

        List<SUser> sysUsers = sUserService.queryUserList(user, page, pageSize);

        return HansJSONResult.ok(sysUsers);
    }


}
