package com.wyc.hm.service;


import com.wyc.hm.entity.Dk;
import com.wyc.hm.entity.Dto.UserDto;
import com.wyc.hm.entity.User;

import java.util.List;

/**
 * Description 用户service层
 *
 * @author ZhengJiawei
 * @date 2019-03-21 10:47:26
 */
public interface UserService {

    User login(User user);

    List<User> getUserList(User user);

    void addDk(Dk dk) throws Exception;

    List<UserDto> getDkList(UserDto userDto);

    void changeUser(User user) throws Exception;

    void addUser(User user) throws Exception;

    void deleteUser(User user) throws Exception;
    Dk haveDk(Dk dk);
    Integer countDk();
}
