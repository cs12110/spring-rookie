package com.pkgs.ctrl.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p/>
 *
 * @author cs12110 created at: 2019/3/1 16:28
 * <p>
 * since: 1.0.0
 */
@Controller
@RequestMapping("/home")
public class HomeCtrl {

    @RequestMapping("/simple")
    public String index() {
        return "simple/index.html";
    }

    @RequestMapping("/forbid")
    public String forbid() {
        return "simple/forbid";
    }
}
