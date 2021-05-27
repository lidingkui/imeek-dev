package com.hubject.user.service;


import com.hubject.utils.PagedGridResult;

import java.util.Date;

public interface AppUserMngService {

    /**
     * 查询管理员列表
     */
    public PagedGridResult queryAllUserList(String nickname,
                                            Integer status,
                                            Date startDate,
                                            Date endDate,
                                            Integer page,
                                            Integer pageSize);

    /**
     * 冻结用户账号，或者解除冻结状态
     */
    public void freezeUserOrNot(String userId, Integer doStatus);

}
