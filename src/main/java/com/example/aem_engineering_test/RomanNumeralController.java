package com.example.aem_engineering_test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RomanNumeralController {

    @GetMapping("/romannumeral")
    @ResponseBody
    public ResponseEntity<?> romanNumeralEndpoint(@RequestParam(name="query", required=false, defaultValue="1") int inputVal) {
        if (inputVal<1 || inputVal>255) {
            return new ResponseEntity<>("Please provide an integer in the range 1-255", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new RomanNumeralResponseBody(inputVal+"", "output"), HttpStatus.OK);
    }
}
