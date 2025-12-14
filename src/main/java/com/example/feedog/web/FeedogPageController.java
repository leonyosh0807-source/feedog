package com.example.feedog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedogPageController {

    @GetMapping("/feed")
    public String feedPage() {
        return "feed";
    }

    @GetMapping("/logs")
    public String logsPage() {
        return "logs";
    }
}
