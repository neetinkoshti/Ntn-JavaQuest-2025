package org.ntn.com.javaconcepts.multithreading;

public class PrintEvenOddNumbersUsingThread {

    public static void main(String[] args) {

        int LIMIT = 20;

        PrintEvenOddNumbers printEvenOddNumbers = new PrintEvenOddNumbers(LIMIT);

        Thread evenNumberThread = new Thread(() -> {
            try {
                printEvenOddNumbers.printEvenNumbers();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread oddNumberThread = new Thread(() -> {
            try {
                printEvenOddNumbers.printOddNumbers();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        evenNumberThread.start();
        oddNumberThread.start();

    }

}

class PrintEvenOddNumbers{

    int limit;

    int counter = 1;

    public PrintEvenOddNumbers(int limit){
        this.limit = limit ;
    }

    public synchronized void printEvenNumbers() throws InterruptedException {

        while( counter <= limit){
            if(counter % 2 == 0){
                System.out.print(counter+" ");
                counter++;
                notify();
            }else{
                wait();
            }
        }
    }

    public synchronized void printOddNumbers() throws InterruptedException {
        while( counter <= limit){
            if(counter % 2 != 0){
                System.out.print(counter+" ");
                counter++;
                notify();
            }else{
                wait();
            }
        }
    }

}


