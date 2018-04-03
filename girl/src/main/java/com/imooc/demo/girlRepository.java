package com.imooc.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface girlRepository extends JpaRepository<girl,Integer> {

    //按年龄查询
    public List<girl> findByAge(Integer age);
}
