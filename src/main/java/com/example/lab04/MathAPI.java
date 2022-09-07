package com.example.lab04;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathAPI {
    @GetMapping("/plus/{n1}/{n2}")
    public double myPlus(@PathVariable("n1") double a, @PathVariable("n2") double b) {
        return a + b;
    }

    @GetMapping("/minus/{n1}/{n2}")
    public double myMinus(@PathVariable("n1") double a, @PathVariable("n2") double b) {
        return a - b;
    }

    @GetMapping("/divide/{n1}/{n2}")
    public double myDivide(@PathVariable("n1") double a, @PathVariable("n2") double b) {
        return a / b;
    }

    @GetMapping("/multi/{n1}/{n2}")
    public double myMulti(@PathVariable("n1") double a, @PathVariable("n2") double b) {
        return a * b;
    }

    @GetMapping("/mod/{n1}/{n2}")
    public double myMod(@PathVariable("n1") double a, @PathVariable("n2") double b) {
        return a % b;
    }

    @PostMapping(value = "/max", consumes = MediaType.APPLICATION_JSON_VALUE)
    public double myMax(@RequestBody MaxRequest v) {
        return Math.max(v.a, v.b);
    }
}
