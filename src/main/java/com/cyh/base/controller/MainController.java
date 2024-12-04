package com.cyh.base.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cyh.base.dto.ApiResponse;
import com.cyh.base.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @GetMapping("/main")
    public String getMainPage(Model model,
                               @RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "exception", required = false) String exception) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "main.html";
    }

    @GetMapping("/")
    public String getIndexPage(Model model,
                              @RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "exception", required = false) String exception) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        // return "vue/index";
        return "index.html";
    }
}