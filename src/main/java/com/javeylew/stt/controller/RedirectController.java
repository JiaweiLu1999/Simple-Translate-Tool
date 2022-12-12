package com.javeylew.stt.controller;

import com.javeylew.stt.pojo.TranslateInput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RedirectController {

    @GetMapping("/")
    public String toIndexPage(Model model) {
        model.addAttribute("translateInput", new TranslateInput());
        return "index";
    }



}
