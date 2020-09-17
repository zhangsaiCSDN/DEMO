package com.example.studyThread;

import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable implements Runnable {
    public static AtomicInteger at = new AtomicInteger(0);
    @Override
    public void run() {
        myCount();
        System.out.println(at);
    }
    public void myCount(){
        at.getAndAdd(2);
    }
}

class myTest{
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        for (int i = 0;i<10000;i++){
            new Thread(mr).start();
        }
    }
}
