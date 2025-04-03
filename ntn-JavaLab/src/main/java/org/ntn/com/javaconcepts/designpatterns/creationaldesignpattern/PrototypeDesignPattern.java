package org.ntn.com.javaconcepts.designpatterns.creationaldesignpattern;

public class PrototypeDesignPattern {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Prototype Design Pattern");

        long start = System.currentTimeMillis();
        InvoiceFromDB invoiceFromDB = new InvoiceFromDB(1, "Nitin", 1000);
        invoiceFromDB.loadConfigurations();
        long end = System.currentTimeMillis();
        System.out.println(invoiceFromDB + " Time taken : " + (end - start));

        try {
            start = System.currentTimeMillis();
            InvoiceFromDB invoiceFromDB1 = invoiceFromDB.clone();
            end = System.currentTimeMillis();
            System.out.println(invoiceFromDB1 + " Time taken : " + (end - start));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class InvoiceFromDB implements Cloneable {

    private int invoiceNumber;
    private String customerName;
    private double amount;
    private String configurations;

    public void loadConfigurations() throws InterruptedException {
        Thread.sleep(10000);
        configurations = "Loading configurations";
    }

    public InvoiceFromDB(int invoiceNumber, String customerName, double amount) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.amount = amount;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    protected InvoiceFromDB clone() throws CloneNotSupportedException {
        return (InvoiceFromDB) super.clone();
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber=" + invoiceNumber +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                ",configurations =" + configurations +
                '}';
    }
}
