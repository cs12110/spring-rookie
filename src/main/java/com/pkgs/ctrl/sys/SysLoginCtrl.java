package com.pkgs.ctrl.sys;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/6 9:23
 * <p>
 * since: 1.0.0
 */
@Slf4j
@Controller
@RequestMapping("/login/")
public class SysLoginCtrl {


    @RequestMapping("in")
    @ResponseBody
    public String in(String name, String password) {
        log.info(name + ":" + password);
        Map<String, Object> map = new HashMap<>(2);
        map.put("login", true);
        try {
            // 使用shiro进行登录校验
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(name, password);
            subject.login(token);

            map.put("next", "simple/index");
        } catch (Exception e) {
            map.put("login", false);
            map.put("msg", e.getMessage());
            log.error(e.getMessage());
        }
        //登录成功,返回simple/index页面
        return JSON.toJSONString(map);
    }


    @RequestMapping("admin")
    @RequiresPermissions("admin:admin")
    public String admin() {
        return "login/admin";
    }


    @RequestMapping("out")
    public String out() {
        Subject subject = SecurityUtils.getSubject();
        if (null != subject) {
            subject.logout();
        }
        return "simple/index";
    }
}
