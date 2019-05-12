package com.wyc.hm.service;


import com.wyc.hm.entity.Qjsq;

import java.util.List;

/**
 * Description 请假
 *
 * @author ZhengJiawei
 * @date 2019-03-21 10:47:26
 */
public interface QjsqService {

    void addQjsq(Qjsq qjsq) throws Exception;

    List<Qjsq> getQjList(Qjsq qjsq);

    Qjsq getQj(Qjsq qjsq);

}
