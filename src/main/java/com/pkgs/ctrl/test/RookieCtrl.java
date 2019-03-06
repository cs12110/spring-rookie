package com.pkgs.ctrl.test;

import com.pkgs.conf.anno.AntiResubmit;
import com.pkgs.entity.rookie.RookieEntity;
import com.pkgs.service.rookie.RookieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 13:29
 * <p>
 * since: 1.0.0
 */
@Controller
@RequestMapping("/rookie")
@Slf4j
public class RookieCtrl {

    @Autowired
    private RookieService rookieService;


    @RequestMapping("/test")
    @ResponseBody
    public Object test() {

        RookieEntity entity = new RookieEntity();
        entity.setId(1);
        entity.setName("rookie");
        return entity;
    }

    @RequestMapping("/query/{id}")
    @ResponseBody
    public RookieEntity query(@PathVariable("id") Integer id) {
        return rookieService.queryById(id);
    }


    @RequestMapping("/insert/{type}")
    @ResponseBody
    public Integer save(@PathVariable("type") Integer type) {

        RookieEntity entity = new RookieEntity();
        if (type == 1) {
            entity.setName("just rookie");
        } else {
            entity.setName("admin");
        }
        return rookieService.insert(entity);
    }

    @RequestMapping("/submit")
    @ResponseBody
    @AntiResubmit
    public Object submit() {
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }


    @RequestMapping("/cache/{id}")
    @ResponseBody
    public Object cache(@PathVariable("id") Integer id) {
        return rookieService.searchWithCache(id);
    }

    @RequestMapping("/remove/cache/{id}")
    @ResponseBody
    public Object removeCache(@PathVariable("id") Integer id) {

        rookieService.removeLocalCache(id);

        return true;
    }
}
