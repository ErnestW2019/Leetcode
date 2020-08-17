package 多线程;

import java.util.concurrent.CountDownLatch;

public class Foo {
	/************利用全局可见标记量****************/
	/*
    public volatile int flag = 1;
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(flag!=2){

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(flag!=3){
            
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }*/
	
	/************利用CountDownLatch*************/
    public CountDownLatch s2 = new CountDownLatch(1);
    public CountDownLatch s3 = new CountDownLatch(1);
    public Foo() {
        
    }
    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	s2.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
    	s3.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
