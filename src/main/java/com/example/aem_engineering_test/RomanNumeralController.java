package com.example.aem_engineering_test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.IOException;

@Controller
public class RomanNumeralController {
    @GetMapping("/romannumeral")
    @ResponseBody
    public ResponseEntity<?> romanNumeralEndpoint(@RequestParam(name = "query", required = true) int inputVal) {
        if (inputVal < 1 || inputVal > 255) {
            return new ResponseEntity<>("Please provide an integer in the range 1-255", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new RomanNumeralResponseBody(inputVal + "",
                RomanNumeralConverter.romanNumeralConvert(inputVal)), HttpStatus.OK);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?>  handleMissingParams(MethodArgumentTypeMismatchException ex) {
        String name = ex.getParameter().getParameterName();
        return new ResponseEntity<>(name + " parameter must be an integer", HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?>  handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        return new ResponseEntity<>(name + " parameter must be specified", HttpStatus.BAD_REQUEST);
    }
}
