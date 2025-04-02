package org.ntn.com.javaconcepts.designpatterns.creationaldesignpattern;

public class FactoryDesignPattern {

    public static void main(String[] args) {

        InvoiceFactory invoiceFactory = new InvoiceFactory();
        Invoice invoice = invoiceFactory.getInvoice("Sales");
        System.out.println(invoice);

        Invoice invoice1 = invoiceFactory.getInvoice("Service");
        System.out.println(invoice1);
    }
}

class InvoiceFactory {

    public Invoice getInvoice(String invoiceType) {

        if (invoiceType == null) {
            return null;
        }

        if (invoiceType.equalsIgnoreCase("Sales")) {
            return new SalesInvoice(invoiceType);
        } else if (invoiceType.equalsIgnoreCase("Service")) {
            return new ServiceInvoice(invoiceType);
        }
        return null;
    }
}


abstract class Invoice{

    String invoiceNum;
    String invoiceName;
    double invoiceQty;
    String invoiceType;

    public abstract double calculateTotal();


 }

class SalesInvoice extends  Invoice{

    double invoicePrice;
    String invoiceType;

    public SalesInvoice(String invoiceType){
        this.invoiceType = invoiceType;
    }

    public SalesInvoice(String invoiceNum , String invoiceName , double invoiceQty , String invoiceType , double invoicePrice){
        this.invoiceNum = invoiceNum;
        this.invoiceName = invoiceName;
        this.invoiceQty = invoiceQty;
        this.invoiceType = invoiceType;
        this.invoicePrice = invoicePrice;
    }

    public double calculateTotal(){
        return invoiceQty * invoicePrice;
    }

    public String toString(){
        return "Invoice Number : "+invoiceNum + " Invoice Name : "+invoiceName + " Invoice Qty : "+invoiceQty + " Invoice Type : "+invoiceType + " Invoice Price : "+invoicePrice;
    }
}

class ServiceInvoice extends Invoice{

    double invoiceRate;
    double invoiceHours;
    String invoiceType;
    public ServiceInvoice(String invoiceType){
        this.invoiceType = invoiceType;
    }

    public ServiceInvoice(String invoiceNum , String invoiceName , double invoiceQty , String invoiceType , double invoiceRate , double invoiceHours){
        this.invoiceNum = invoiceNum;
        this.invoiceName = invoiceName;
        this.invoiceQty = invoiceQty;
        this.invoiceType = invoiceType;
        this.invoiceRate = invoiceRate;
        this.invoiceHours = invoiceHours;
    }

    public double calculateTotal(){
        return invoiceRate * invoiceHours;
    }

    public String toString(){
        return "Invoice Number : "+invoiceNum + " Invoice Name : "+invoiceName + " Invoice Qty : "+invoiceQty + " Invoice Type : "+invoiceType + " Invoice Rate : "+invoiceRate + " Invoice Hours : "+invoiceHours;
    }

}




