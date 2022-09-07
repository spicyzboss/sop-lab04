package com.example.lab04;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @GetMapping(value = "/getChange/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Change getChange(@PathVariable("n") int n) {
        Change change = new Change();
        change.setB1000(n/1000);
        n = n % 1000;
        change.setB500(n/500);
        n = n % 500;
        change.setB100(n/100);
        n = n % 100;
        change.setB20(n/20);
        n = n % 20;
        change.setB10(n/10);
        n = n % 10;
        change.setB5(n/5);
        n = n % 5;
        change.setB1(n);
        return change;
    }
}
