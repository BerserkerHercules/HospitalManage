package com.wyc.hm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wyc.hm.entity.User;
import com.wyc.hm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Description
 *
 * @author ZhengJiawei
 * @date 2019-03-21 10:48:11
 */
@Controller
public class WebController {

    @Resource
    private UserService userService;

    /**
     * 登陆
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public JSONObject login(User user) {
        User user1 = userService.login(user);
        JSONObject jsonObject = new JSONObject();
        if (user1 != null) {
            return JSON.parseObject("{statusCode:200," +
                    "ks:\"" + user1.getKs() + "\"," +
                    "userId:\"" + user1.getUserId() + "\"," +
                    "permission:\"" + user1.getPermission() + "\"}");
        }
        return jsonObject;
    }

    /**
     * Description 跳转登录
     *
     * @return String
     * @author ZhengJiawei
     * @date 2019-03-20 16:28:37
     */
/*  @RequestMapping(value = "/onLogin")
    @ResponseBody
    public JSONObject index(@RequestBody String code) throws Exception {
        System.out.println("code:"+code);
        Map<String,String> requestUrlParam = new HashMap<String,String>();
        requestUrlParam.put("appid", "wx3d22abdc5ceeb7cb");
        requestUrlParam.put("secret", "b0bde4eb7dcdf9d8bec3f4a6c2b123a2");
        requestUrlParam.put("js_code", code);
        requestUrlParam.put("grant_type", "authorization_code");
        JSONObject jsonObject = JSON.parseObject(HttpUtil.sendPost("https://api.weixin.qq.com/sns/jscode2session", requestUrlParam));
        System.out.print("jsonObject:"+jsonObject);
        return jsonObject;
    }*/

}
