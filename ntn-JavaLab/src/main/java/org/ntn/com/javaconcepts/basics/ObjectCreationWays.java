package org.ntn.com.javaconcepts.basics;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class  ObjectCreationWays{

    public static void main(String[] args) {

        usingConstructor();  // using new keyword
        usingReflection(); // using class.newInstance()
        usingDeserializedMethod();  // using deserialized method
        usingClassForNameMethod(); // using class.forName()
        usingCloneMethod(); // using clone method

    }

    private static void usingCloneMethod() {
        Student student =new Student(5,"simon","78 oxford st");
        Student newStudent = student.clone();
        System.out.println("Student created using clone : "+newStudent);
    }

    private static void usingClassForNameMethod() {

        try {
            Class<?> aClass = Class.forName("org.ntn.com.javaconcepts.basics.Student");


            Constructor<?> constructor = aClass.getConstructor(int.class,String.class,String.class);
            Student student = (Student) constructor.newInstance(4,"ntn","1212 cent st");
            System.out.println("Student created using class.forName and its constructor : "+student);

            Constructor<?> constructor1 = aClass.getDeclaredConstructor(String.class);
            constructor1.setAccessible(true);
            Student student1 = (Student) constructor1.newInstance("nitin");
            System.out.println("to check private constructor : "+student1);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void usingDeserializedMethod() {
        Student student = new Student(3,"tom","2354 st central");


        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serial.ser"));
            outputStream.writeObject(student);
            outputStream.close();

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serial.ser"));
            Student student1 = (Student)inputStream.readObject();
            System.out.println("Student created using deserialized method : "+student1);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void usingReflection() {
        try {
            Student student = Student.class.newInstance();
            student.setRollNo(2);
            student.setName("Jane Doe");
            student.setAddress("456 Elm St");
            // Using reflection to create an instance of Student
            System.out.println("Student created using reflection: " + student);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void usingConstructor() {
        Student student1 = new Student(1, "John Doe", "123 Main St");
        System.out.println("Student created using constructor: " + student1);
    }
}

class Student implements Serializable , Cloneable{
    int rollNo;
    String name;
    String address;

    private Student(String name){
        this.name = name;
        System.out.println("private constructor accessed outside class");
    }

    public Student(int rollNo, String name, String address) {
        this.rollNo = rollNo;
        this.name = name;
        this.address = address;
    }

    public Student() {
        this.rollNo = 0;
        this.name = "Default Name";
        this.address = "Default Address";
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public Student clone() {
        try {
            Student clone = (Student) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

