package com.pkgs.ctrl.rediz;

import com.alibaba.fastjson.JSON;
import com.pkgs.entity.sys.SysUser;
import com.pkgs.service.rediz.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/6 16:28
 * <p>
 * since: 1.0.0
 */
@Slf4j
@Controller
@RequestMapping("/redis/")
public class RedisCtrl {

    @Autowired
    private RedisService redisService;


    @RequestMapping("/op")
    @ResponseBody
    public String operation() {

        SysUser sysUser = new SysUser();
        sysUser.setPassword("123456");
        sysUser.setName("haiyan");


        redisService.set(sysUser.getName(), JSON.toJSONString(sysUser));

        String value = redisService.get(sysUser.getName());

        log.info(value);

        return "1231231";
    }
}
