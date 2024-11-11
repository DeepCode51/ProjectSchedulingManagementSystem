package com.esms.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageUtils {
    @RequestMapping("/toPage.do")
    public String toPage(String url) {
        return url;
    }
}
