package com.learn.threadpool.controller;

import com.learn.threadpool.pojo.countdownlatch.Thread1;
import com.learn.threadpool.pojo.countdownlatch.Thread2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * @author lijy
 * @create 2019-05-30 7:12
 * @description
 */
@RestController
public class ThreadPoolController {

    @RequestMapping("test-countdownlatch")
    public void testCountDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread1 thread1 = new Thread1(countDownLatch);
        Thread2 thread2 = new Thread2(countDownLatch);
        thread1.start();
        thread2.start();
        try {
            countDownLatch.await();
            System.out.println("main...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}