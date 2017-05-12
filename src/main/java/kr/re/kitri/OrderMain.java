package kr.re.kitri;


import kr.re.kitri.model.Order;
import kr.re.kitri.service.OrderService;

import java.util.List;

public class OrderMain {
    public static void main(String[] args){


        OrderService service = new OrderService();

        List<Order> list = service.getOrderlist();


        list.stream().
                forEach(x -> System.out.println(x));



    }
}