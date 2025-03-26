package org.ntn.com.javaconcepts.designpatterns.creationaldesignpattern;

import java.io.*;

public record SingletonDesignPattern() {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Eager Initialization
        eagerInitilization();

        // Thread Safety
        threadSafetyChecks();

        // using serialization and Deserialization
        usingSerialization();

    }

    private static void usingSerialization() throws IOException, ClassNotFoundException {
        System.out.println("Using Serialization");
        SingletonDemo.SingletonPatternSerializationDeserialization instance1 = SingletonDemo.SingletonPatternSerializationDeserialization.getInstance();

        // Serialized the object
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serialization.ser"));
        outputStream.writeObject(instance1);
        outputStream.close();

        // Deserialized the object
        SingletonDemo.SingletonPatternSerializationDeserialization serializedInstance;
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serialization.ser"));
        serializedInstance = (SingletonDemo.SingletonPatternSerializationDeserialization) inputStream.readObject();
        inputStream.close();

        System.out.println("Instance Before Serialized :"+instance1);
        System.out.println("Instance After Serialized : "+serializedInstance);


    }

    private static void threadSafetyChecks() {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread Safety check 1: "+Thread.currentThread().getName());
            SingletonDemo.SingletonPatternWithThreadSafety withThreadSafety1 =SingletonDemo.SingletonPatternWithThreadSafety.getInstance();
            System.out.println("Thread Safety check instance 1 : "+withThreadSafety1);
        });



        Thread thread2 = new Thread(() -> {
            System.out.println("Thread Safety check 2: "+Thread.currentThread().getName());
            SingletonDemo.SingletonPatternWithThreadSafety withThreadSafety1 =SingletonDemo.SingletonPatternWithThreadSafety.getInstance();
            System.out.println("Thread Safety check instance 2 : "+withThreadSafety1);
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("Thread Safety check 3: "+Thread.currentThread().getName());
            SingletonDemo.SingletonPatternWithThreadSafety withThreadSafety1 =SingletonDemo.SingletonPatternWithThreadSafety.getInstance();
            System.out.println("Thread Safety check instance 3 : "+withThreadSafety1);
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void eagerInitilization() {
        SingletonDemo.SingletonPatternEagerInitialization eagerInitialization1 = SingletonDemo.SingletonPatternEagerInitialization.getInstance();
        SingletonDemo.SingletonPatternEagerInitialization eagerInitialization2 = SingletonDemo.SingletonPatternEagerInitialization.getInstance();
        SingletonDemo.SingletonPatternEagerInitialization eagerInitialization3 = SingletonDemo.SingletonPatternEagerInitialization.getInstance();

        System.out.println(eagerInitialization1);
        System.out.println(eagerInitialization2);
        System.out.println(eagerInitialization3);
    }
}

class SingletonDemo{

     static class SingletonPatternEagerInitialization{

        private static SingletonPatternEagerInitialization INSTANCE = new SingletonPatternEagerInitialization();

        private SingletonPatternEagerInitialization(){

        }

        public static SingletonPatternEagerInitialization getInstance(){
            return INSTANCE;
        }
    }

    static class SingletonPatternWithThreadSafety{

         private static SingletonPatternWithThreadSafety INSTANCE ;

         private SingletonPatternWithThreadSafety(){

         }

         public static SingletonPatternWithThreadSafety getInstance(){

             if(INSTANCE ==null){
                 synchronized (SingletonPatternWithThreadSafety.class){
                     if(INSTANCE ==null){
                         INSTANCE = new SingletonPatternWithThreadSafety();
                     }
                 }
             }
             return INSTANCE;
         }

    }

    static class SingletonPatternSerializationDeserialization implements Serializable{

        private static final long serialVersionUId = 1L;

         private static SingletonPatternSerializationDeserialization INSTANCE;

         private SingletonPatternSerializationDeserialization(){

         }

         public static SingletonPatternSerializationDeserialization getInstance(){
             if(INSTANCE == null){
                 INSTANCE =  new SingletonPatternSerializationDeserialization();
             }
             return INSTANCE;
         }


         @Serial
         protected Object readResolve(){
             return getInstance();
        }
    }



}

