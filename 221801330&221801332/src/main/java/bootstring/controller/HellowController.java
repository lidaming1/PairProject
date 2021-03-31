package com.daming.bootstring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName : com.daming.bootstring.controller.HellowController
 * 221801332
 */
@Controller  //注意这里必须为Controller
class HelloController {

    @RequestMapping("/hello")
    public String helloHtml() {
        return "index";
    }
}
