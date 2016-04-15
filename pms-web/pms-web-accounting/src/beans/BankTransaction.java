/*
 * BankTransaction.java
 *
 * Created on 29 de abril de 2007, 11:21
 */

package beans;

import java.beans.*;

/**
 * @author Developer
 */
public class BankTransaction {
    
    private short  bankId;
    private long   accountNumber;
    private int    transactionNumber;
    private String transactionDate;
    private String transactionType;
    private short  transactionWay;
    private int    documentNumber;
    private double transactionAmount;
    private double ITFTransaction;
    private short  customerId;
    private int    receiptNumber;
   
    public BankTransaction() {
        bankId = 0;
        accountNumber = 0;
        transactionNumber = 0;
        transactionDate = "";
        transactionType = "";
        transactionWay = 0;
        documentNumber = 0;
        transactionAmount = 0;
    }
    
    public short getBankId() {
        return bankId;
    }

    public void setBankId(short bankId) {
        this.bankId = bankId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }
    
    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public short getTransactionWay() {
        return transactionWay;
    }

    public void setTransactionWay(short transactionWay) {
        this.transactionWay = transactionWay;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double amountTransaction) {
        this.transactionAmount = amountTransaction;
    }

    public double getITFTransaction() {
        return ITFTransaction;
    }

    public void setITFTransaction(double ITFTransaction) {
        this.ITFTransaction = ITFTransaction;
    }

    public short getCustomerId() {
        return customerId;
    }

    public void setCustomerId(short customerId) {
        this.customerId = customerId;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

}
