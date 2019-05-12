package com.wyc.hm.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wyc.hm.entity.Qjsq;
import com.wyc.hm.service.QjsqService;
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
@RequestMapping(value = "/qjsq")
public class QjsqController {
    @Resource
    private QjsqService qjsqService;

    @RequestMapping(value = "/addQjsq")
    public JSONObject addQj(@RequestBody Qjsq qjsq) {
        JSONObject jsonObject = JSON.parseObject("{success:true,msg:\"提交成功！\"}");
        qjsq.setQjyy("0".equals(qjsq.getQjyy()) ? "事假" : "病假");
        try {
            qjsqService.addQjsq(qjsq);
        } catch (Exception e) {
            System.out.println("------提交申请失败：" + e);
            return JSON.parseObject("{success:false,msg:\"提交失败！\"}");
        }
        return jsonObject;
    }

    @RequestMapping(value = "/getQjList")
    public JSONArray getQjList(@RequestBody Qjsq qjsq) {
        List<Qjsq> list = qjsqService.getQjList(qjsq);
        String jsonStr = JsonUtil.serializeDate(list);
        return JSON.parseArray(jsonStr);
    }

    @RequestMapping(value = "/getQjXx")
    public JSONObject getQjXx(@RequestBody Qjsq qjsq) {
        Qjsq qjsq1 = qjsqService.getQj(qjsq);
        String jsonStr = JsonUtil.serialize(qjsq1);
        return JSON.parseObject(jsonStr);
    }

    @RequestMapping(value = "/agreeQj")
    public JSONObject agreeQj(@RequestBody Qjsq qjsq) {
        try{
            qjsqService.agreeQj(qjsq);
        }catch (Exception e){
            return JSON.parseObject("{success:false,msg:\"审批失败！\"}");
        }
        return JSON.parseObject("{success:true,msg:\"审批成功！\"}");
    }

    public static void main(String[] args) {
        System.out.println("------ 开始时间：");
    }

}
