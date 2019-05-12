package com.wyc.hm.service.impl;


import com.wyc.hm.entity.Dk;
import com.wyc.hm.entity.Dto.UserDto;
import com.wyc.hm.entity.User;
import com.wyc.hm.mapper.UserMapper;
import com.wyc.hm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 *
 * @author ZhengJiawei
 * @date 2019-03-21 10:47:40
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        User user1 = userMapper.userLogin(user);
        return user1;
    }

    @Override
    public List<User> getUserList(User user) {
        return userMapper.getUserList(user);
    }

    @Override
    public void addDk(Dk dk) throws Exception {
        userMapper.addDk(dk);
    }

    @Override
    public List<UserDto> getDkList(UserDto userDto) {
        return userMapper.getDkList(userDto);
    }

    @Override
    public void changeUser(User user) throws Exception {
        userMapper.changeUser(user);
    }

    @Override
    public void addUser(User user) throws Exception {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(User user) throws Exception {
        userMapper.deleteUser(user);
    }
}
