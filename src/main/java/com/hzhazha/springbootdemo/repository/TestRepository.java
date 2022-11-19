package com.hzhazha.springbootdemo.repository;

import com.hzhazha.springbootdemo.bean.TestBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //扩展Jpa的注解
public interface TestRepository extends JpaRepository<TestBean, Long> {

    //查询单条数据
    TestBean findByIdIs(Long id);
    //查询相同年龄的人
    List<TestBean> findByAge(Integer age);
    //查询相同姓名的人
    List<TestBean> findByName(String name);

}