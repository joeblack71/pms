/*
 * CustomerProduction.java
 *
 * Created on March 06, 2007, 11:40 AM
 */

package beans;

/**
 *
 * @author  Johnny Olivas
 * @version
 */
public class CustomerProduction implements java.io.Serializable{

    private short  hotelId;
    private String period;
    private String customerId;
    private String customerName;
    private double netTotal;
    private double tax1Total;
    private double tax2Total;
    private double production;

    /** Creates new CustomerProduction */
    public CustomerProduction() {
    }

    public short getHotelId() {
        return hotelId;
    }
    public void setHotelId(short _hotelId) {
        this.hotelId = _hotelId;
    }

    public String getPeriod() {
        return period;
    }
    public void setPeriod(String _period) {
        this.period = _period;
    }

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String _customerId) {
        this.customerId = _customerId;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String _customerName) {
        this.customerName = _customerName;
    }

    public double getNetTotal() {
        return netTotal;
    }
    public void setNetTotal(double _netTotal) {
        this.netTotal = _netTotal;
    }

    public double getTax1Total() {
        return tax1Total;
    }
    public void setTax1Total(double _tax1Total) {
        this.tax1Total = _tax1Total;
    }

    public double getTax2Total() {
        return tax2Total;
    }
    public void setTax2Total(double _tax2Total) {
        this.tax2Total = _tax2Total;
    }

    public double getProduction() {
        return production;
    }
    public void setProduction(double _production) {
        this.production = _production;
    }

}