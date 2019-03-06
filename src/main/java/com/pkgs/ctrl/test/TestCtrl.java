package com.pkgs.ctrl.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/6 13:19
 * <p>
 * since: 1.0.0
 */
@Controller
@RequestMapping("/test/")
public class TestCtrl {


    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return TestCtrl.class.getName();
    }
}
