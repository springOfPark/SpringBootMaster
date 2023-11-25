package me.ktpark.websvc.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {

    @RequestMapping("/{path1}")
    public String baseViewPage1(@PathVariable String path1) {
        return String.format("/websvc/%s", path1);
    }

    @RequestMapping("/{path1}/{path2}")
    public String baseViewPage2(@PathVariable String path1, @PathVariable String path2) {
        return String.format("/websvc/%s/%s", path1, path2);
    }

    @RequestMapping("/{path1}/{path2}/{path3}")
    public String baseViewPage3(@PathVariable String path1, @PathVariable String path2, @PathVariable String path3) {
        return String.format("/websvc/%s/%s/%s", path1, path2, path3);
    }
}
