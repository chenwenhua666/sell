package com.plm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * chenwenhua
 * 2018\8\31 0031
 * 17:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    //private static  final Logger log = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test(){
        String name = "plm";
        String passwd = "123456";
        log.info("name={},passwd={}",name,passwd);
        log.debug("debug====");
        log.error("error====");

    }
}
