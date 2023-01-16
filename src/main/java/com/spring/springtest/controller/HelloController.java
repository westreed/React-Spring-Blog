package com.spring.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // GET Method
    public String Hello(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("CustomerName", name);
        return "hello";
    }

    @GetMapping("API")
    @ResponseBody
    public Customer HelloAPI(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "first",required = false) String first
    ){
        Customer customer = new Customer();
        customer.setName(name);
        customer.setFirst(first);
        return customer;
    }

    static class Customer {
        private String name;
        private String first;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }
    }
}
