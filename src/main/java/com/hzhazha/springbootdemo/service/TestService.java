package com.hzhazha.springbootdemo.service;

import com.hzhazha.springbootdemo.bean.TestBean;
import com.hzhazha.springbootdemo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;

    //查询
    public List<TestBean> findByName(String name){
        return testRepository.findByName(name);
    }

    public List<TestBean> findByAge(Integer age){
        return testRepository.findByAge(age);
    }

    public TestBean findByIdIs(Long id){
        return testRepository.findByIdIs(id);
    }

    //更新 or 新增
    public void insertOrUpdate(TestBean testBean){
        testRepository.save(testBean);
    }

    //删
    public void delete(TestBean testBean){
        testRepository.delete(testBean);
    }

    public void delete(Long id){
        testRepository.deleteById(id);
    }

}
