/*
 * Receipt.java
 *
 * Created on Febrery 26, 2007, 9:08 PM
 */

package beans;

import java.sql.Date;
/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class Receipt implements java.io.Serializable{

    private short   hotelId;        // tinyint
    private short   receiptType;    // tinyint
    private short   receiptSerial;  // smallint
    private int     correlative;    // int
    private Date    issueDate;      // date
    private Date    paymentDate;    // date
    private String  entityId;       // char(11) /* Customer or Provider */
    private String  entityName;     // char(30)
    private double  net;            // double
    private boolean exempt;         // boolean
    private boolean applyService;   // boolean
    private double  servicePercent; // double
    private double  tax1;           // double
    private double  service;        // double
    private double  receiptTotal;   // double
    private short   paymentType;    // tinyint(2)
    private String  money;          // char(1)
    private double  exchange;       // double
    private String  status;         // char(1)
    private String  madeBy;         // char(3)
    private String  madeOn;         // timestamp
    private String  updatedBy;      // char(3)
    private String  updatedOn;      // timestamp

    /** Creates new Receipt */
    public Receipt() {
        String SPACES = "";

        /*this.issueDate   = SPACES;
        this.paymentDate = SPACES;*/
        this.entityId    = SPACES;
        this.entityName  = SPACES;
        this.money       = SPACES;
        this.status      = SPACES;
        this.madeBy      = SPACES;
        this.updatedBy   = SPACES;
    }

    public short getHotelId() {
        return hotelId;
    }
    public void setHotelId(short hotelId) {
        this.hotelId = hotelId;
    }

    public short getReceiptType() {
        return receiptType;
    }
    public void setReceiptType(short receiptType) {
        this.receiptType = receiptType;
    }

    public short getReceiptSerial() {
        return receiptSerial;
    }
    public void setReceiptSerial(short receiptSerial) {
        this.receiptSerial = receiptSerial;
    }

    public int getCorrelative() {
        return correlative;
    }
    public void setCorrelative(int correlative) {
        this.correlative = correlative;
    }

    public Date getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getEntityId() {
        return entityId;
    }
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public double getNet() {
        return net;
    }
    public void setNet(double net) {
        this.net = net;
    }

    public double getTax1() {
        return tax1;
    }
    public void setTax1(double tax1) {
        this.tax1 = tax1;
    }

    public double getService() {
        return service;
    }
    public void setService(double service) {
        this.service = service;
    }

    public double getReceiptTotal() {
        return receiptTotal;
    }
    public void setReceiptTotal(double receiptTotal) {
        this.receiptTotal = receiptTotal;
    }

    public boolean isExempt() {
        return exempt;
    }
    public void setExempt(boolean exempt) {
        this.exempt = exempt;
    }

    public boolean isApplyService() {
        return applyService;
    }
    public void setApplyService(boolean applyService) {
        this.applyService = applyService;
    }

    public double getServicePercent() {
        return servicePercent;
    }
    public void setServicePercent(double servicePercent) {
        this.servicePercent = servicePercent;
    }

    public short getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(short paymentType) {
        this.paymentType = paymentType;
    }

    public String getMoney() {
        return money;
    }
    public void setMoney(String money) {
        this.money = money;
    }

    public double getExchange() {
        return exchange;
    }
    public void setExchange(double exchange) {
        this.exchange = exchange;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getMadeBy() {
        return madeBy;
    }
    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }

    public String getMadeOn() {
        return madeOn;
    }
    public void setMadeOn(String madeOn) {
        this.madeOn = madeOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }
    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

}