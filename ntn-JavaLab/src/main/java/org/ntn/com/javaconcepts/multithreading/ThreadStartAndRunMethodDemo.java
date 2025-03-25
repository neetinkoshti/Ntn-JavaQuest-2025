package org.ntn.com.javaconcepts.multithreading;

public class ThreadStartAndRunMethodDemo {

    public static void main(String[] args) {

        ThreadDemo thread = new ThreadDemo();
        thread.run();
        thread.start();


    }

}

class ThreadDemo extends Thread{

    @Override
    public void run(){
        System.out.println("Thread is running: "+ Thread.currentThread().getName());
    }

   /* public void start(){
        System.out.println("Start is running: " + Thread.currentThread().getName());
    }*/
}
