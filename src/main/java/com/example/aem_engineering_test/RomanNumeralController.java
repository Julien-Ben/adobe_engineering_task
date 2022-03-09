package com.example.aem_engineering_test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RomanNumeralController {
    private static final String template = "Hello, %s!";

    @GetMapping("/hello-world")
    @ResponseBody
    public RomanNumeralResponseBody romanNumeralEndpoint(@RequestParam(name="inputVal", required=false, defaultValue="1") String inputVal) {
        return new RomanNumeralResponseBody(inputVal, "output");
    }
}
