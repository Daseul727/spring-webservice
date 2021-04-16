package com.kito.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class webController {

    /*
    * @GetMapping == @RequestMapping(value="/", method = RequestMethod.GET)
    * */

    @GetMapping("/")
    public String main(){
        System.out.println("main jsp로 갑니다-----------------------------");
        return "main";
    }
}
