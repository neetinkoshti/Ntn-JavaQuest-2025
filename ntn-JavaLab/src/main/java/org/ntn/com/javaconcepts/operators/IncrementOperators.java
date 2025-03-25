package org.ntn.com.javaconcepts.operators;

public record IncrementOperators() {

    public static void main(String[] args) {

        incrementOperator();

        incrementOperator1();

        operatorWithString();


    }

    private static void operatorWithString() {
        System.out.println("hello" + 1 + 2 );  // hello12
        System.out.println(1+2+"hello");  //3hello
        System.out.println("hello" + (1 + 2) );  // hello3
        System.out.println(1+(2+"hello"));  //12hello
    }

    private static void incrementOperator1() {
        int num = 5 ;
        System.out.println(num++ + ++num); // 12
    }

    private static void incrementOperator() {
        int num =10;
        System.out.println("Increment Operator working ");
        System.out.println(num++); // first print then increment

        System.out.println(++num); // first increment then  print
    }
}
