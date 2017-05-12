package kr.re.kitri.model;


public class Order {

    private int customerid;
    private String username;
    private String address;
    private String email;
    private int order_num;
    private String order_date;
    private String pro_name;


    @Override
    public String toString() {
        return "[Order table >>\t" +
                "customerid > " + customerid +
                "\tusername > " + username +
                "\taddress > " + address +
                "\temail > " + email +
                "\torder_num > " + order_num +
                "\torder_date > " + order_date +
                "\tpro_name > " + pro_name +
                ']';
    }

    public Order(int customerid, String username, String address, String email, int order_num, String order_date, String pro_name) {
        this.customerid = customerid;
        this.username = username;
        this.address = address;
        this.email = email;
        this.order_num = order_num;
        this.order_date = order_date;
        this.pro_name = pro_name;
    }


    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }
}