package cn.tedu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BMIController {
    @RequestMapping("/bmi")
    @ResponseBody
    public String bmi(double height,double weight){
        double bmi = weight/(height*height);
        System.out.println(bmi);
        if (bmi<15){
            return "对不起，数据有误！";
        }else if (bmi<18.5) {
            return "偏瘦";
        }else if (bmi<=24){
            return "正常";
        }else if (bmi<=28){
            return "微胖";
        }else  return "有点胖了";

    }
}
