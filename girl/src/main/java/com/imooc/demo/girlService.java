package com.imooc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class girlService{

    @Autowired
    private girlRepository girlrepository;

    //@注释为事物控制
    @Transactional
    public void insertTwo(){

        girl Girl1=new girl();
        Girl1.setCupSize("A");
        Girl1.setAge(18);
        girlrepository.save(Girl1);

        girl Girl2=new girl();
        Girl2.setCupSize("E");
        Girl2.setAge(20);
        girlrepository.save(Girl2);
    }
}
