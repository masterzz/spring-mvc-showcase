package org.springframework.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TController {
    @RequestMapping("/query.do")
    public void query() {
        System.out.println("query");
    }
}
