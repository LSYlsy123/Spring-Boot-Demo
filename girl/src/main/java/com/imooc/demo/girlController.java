package com.imooc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class girlController {

    @Autowired
    private girlRepository girlrepository;

    @Autowired
    private girlService girlservice;

    /**
     *查询女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<girl> girlList(){

        return girlrepository.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public girl girlAdd(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        girl Girl=new girl();
        Girl.setAge(age);
        Girl.setCupSize(cupSize);

        return girlrepository.save(Girl);
    }

    //查询一个女生
    @GetMapping(value = "/girls/{id}")
    public girl girlFindOne(@PathVariable("id") Integer id){
        return girlrepository.getOne(id);
    }

    //修改一个女生
    @PutMapping(value = "/girls/{id}")
    public girl girlUpdate(@PathVariable("id") Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        girl Girl=new girl();
        Girl.setId(id);
        Girl.setCupSize(cupSize);
        Girl.setAge(age);
        return girlrepository.save(Girl);
    }

    //删除一个女生
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlrepository.deleteById(id);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/{age}")
    public List<girl> girlFindByAge(@PathVariable("age") Integer age){
        return girlrepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlservice.insertTwo();
    }
}
