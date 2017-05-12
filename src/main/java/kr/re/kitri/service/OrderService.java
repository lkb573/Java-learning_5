package kr.re.kitri.service;

import kr.re.kitri.model.Order;
import kr.re.kitri.util.OrderConstants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OrderService {

    public OrderService() {
        try {
            Class.forName(OrderConstants.DRIVER_POSTGRES);
            System.out.println("driver check");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getOrderlist() {

        String query =
                "select a.cust_id, a.username, a.address, a.email, b.order_num, b.order_date, b.pro_name " +
                        "from customer a, orders b " +
                        "where a.cust_id = b.cust_id " +
                        "order by cust_id;";


        List<Order> list = new ArrayList<>();

        try {
            Connection conn =
                    DriverManager.getConnection(
                            OrderConstants.DB_URL,
                            OrderConstants.USERNAME,
                            OrderConstants.PASSWORD);

            PreparedStatement pst = conn.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                list.add(new Order(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6),
                        rs.getString(7)));

            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;

    }
}
