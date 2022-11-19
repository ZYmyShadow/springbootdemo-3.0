package com.hzhazha.springbootdemo.controller;

import com.hzhazha.springbootdemo.bean.TestBean;
import com.hzhazha.springbootdemo.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController//接口层注释
@RequestMapping(value = "/test")
public class TestController {

    private TestService testService;

    public TestController(TestService testService){
        this.testService = testService;
    }

    @GetMapping(value = "/hello") //GET接口注解
    //@PostMapping(value = "/hello") //POST接口注解
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format("Hello %s", name);
    }

    @PostMapping(value = "/insertorupdate")
    public String insertOrUpdate(@RequestBody TestBean testBean){
        testService.insertOrUpdate(testBean);
        return String.format(testBean.toString());
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestBody TestBean testBean){
        testService.delete(testBean);
        return String.format(testBean.toString());
    }

    @PostMapping(value = "/deletebyid")
    public String deleteById(@RequestBody Map<String,Object> map){
        testService.delete(((Integer)map.get("id")).longValue());
        return String.format(map.toString());
    }

    @PostMapping(value = "/findbyid")
    public TestBean findByIdIs(@RequestParam Integer id){
        return testService.findByIdIs(id.longValue());
    }

    @PostMapping(value = "/findbyage")
    public List<TestBean> findByAge(@RequestParam Integer age){
        return testService.findByAge(age);
    }

    @PostMapping(value = "/findbyname")
    public List<TestBean> findByName(@RequestParam String name){
        return testService.findByName(name);
    }

}
