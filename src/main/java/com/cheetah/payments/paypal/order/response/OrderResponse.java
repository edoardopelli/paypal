package com.cheetah.payments.paypal.order.response; 
import java.util.Date;
import java.util.List; 
public class OrderResponse{
    public String id;
    public String intent;
    public String status;
    public List<PurchaseUnitResponse> purchase_units;
    public Date create_time;
    public List<Link> links;
}
