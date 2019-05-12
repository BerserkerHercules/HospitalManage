package com.wyc.hm.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wyc.hm.entity.Dk;
import com.wyc.hm.entity.Dto.UserDto;
import com.wyc.hm.entity.User;
import com.wyc.hm.service.UserService;
import com.wyc.hm.util.JsonUtil;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 *
 * @author ZhengJiawei
 * @date 2019-03-21 10:49:24
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/addDk")
    public JSONObject addDk(@RequestBody Dk dk) {
        try{
            userService.addDk(dk);
        }catch (Exception e){
            return JSON.parseObject("{success:false,msg:\"打卡失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"打卡成功！\"}");
    }

    @RequestMapping(value = "/getDkList")
    public JSONArray getDkList(@RequestBody UserDto userDto) {
        List<UserDto> list = userService.getDkList(userDto);
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/getUserList")
    public JSONArray getUserList(@RequestBody User user) {
        List<User> list = userService.getUserList(user);
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/changeUser")
    public JSONObject changeUser(@RequestBody User user) {
        try{
            userService.changeUser(user);
        }catch (Exception e){
            return JSON.parseObject("{success:false,msg:\"修改失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"修改成功！\"}");
    }

    @RequestMapping(value = "/addUser")
    public JSONObject addUser(@RequestBody User user) {
        try{
            userService.addUser(user);
        }catch (Exception e){
            return JSON.parseObject("{success:false,msg:\"添加失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"添加成功！\"}");
    }

    @RequestMapping(value = "/deleteUser")
    public JSONObject deleteUser(@RequestBody User user) {
        try{
            userService.deleteUser(user);
        }catch (Exception e){
            return JSON.parseObject("{success:false,msg:\"删除失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"删除成功！\"}");
    }

}
