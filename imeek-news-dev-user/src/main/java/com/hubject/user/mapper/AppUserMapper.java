package com.hubject.user.mapper;

import com.hubject.my.mapper.MyMapper;
import com.hubject.pojo.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserMapper extends MyMapper<AppUser> {
}