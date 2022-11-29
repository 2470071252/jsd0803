package com.example.boot01_1.controller;

import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BMIController {
    @RequestMapping("/bmi")
    @ResponseBody
    public String bmi(double h,double w){
        double bmi = w/(h*h);
        System.out.println(bmi);
        if (bmi<18.5){
            return "偏瘦了";
        }else if (bmi<=24){
            return "正常";
        }else if (bmi<=28){
            return "有点胖了";
        }else  return "该减肥了";
    }
}
