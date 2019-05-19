package com.wyc.hm.mapper;


import com.wyc.hm.entity.Dk;
import com.wyc.hm.entity.Dto.UserDto;
import com.wyc.hm.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description
 *
 * @author ZhengJiawei
 * @date 2019-03-21 10:46:50
 */
@Mapper
public interface UserMapper {

    User userLogin(User user);

    List<User> getUserList(User user);

    void addDk(Dk dk) throws Exception;

    List<UserDto> getDkList(UserDto userDto);

    void changeUser(User user) throws Exception;

    void addUser(User user) throws Exception;

    void deleteUser(User user) throws Exception;

    Dk haveDk(Dk dk);

    Integer countDk(Dk dk);

}
