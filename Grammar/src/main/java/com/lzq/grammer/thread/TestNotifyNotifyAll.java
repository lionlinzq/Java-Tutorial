package com.lzq.grammer.thread;

/**
 * @author Lin
 */
public class TestNotifyNotifyAll {

    private static Object obj = new Object();

    public static void main(String[] args) {

        //测试 RunnableImplA wait()
        Thread t1 = new Thread(new RunnableImplA(obj));
        Thread t2 = new Thread(new RunnableImplA(obj));
        t1.start();
        t2.start();

        //RunnableImplB notify()
        Thread t3 = new Thread(new RunnableImplB(obj));
        t3.start();


//		//RunnableImplC notifyAll()
//		Thread t4 = new Thread(new RunnableImplC(obj));
//		t4.start();
    }

}


class RunnableImplA implements Runnable {

    private Object obj;

    public RunnableImplA(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println("这是RunnableImplA类的run方法");
        synchronized (obj) {
            System.out.println("obj对象被RunnableImplA锁住");
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("obj对象继续在RunnableImplA中使用");
        }
    }
}

class RunnableImplB implements Runnable {

    private Object obj;

    public RunnableImplB(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println("这是RunnableImplB类的run方法");
        System.out.println("睡眠3秒...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj) {
            System.out.println("notify obj on RunnableImplB");
            obj.notify();
        }
    }
}

class RunnableImplC implements Runnable {

    private Object obj;

    public RunnableImplC(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        System.out.println("这是RunnableImplC类的run方法");
        System.out.println("睡眠3秒...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj) {
            System.out.println("notifyAll obj on RunnableImplC");
            obj.notifyAll();
        }
    }
}