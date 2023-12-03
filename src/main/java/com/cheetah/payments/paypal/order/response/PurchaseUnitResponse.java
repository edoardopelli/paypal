package com.cheetah.payments.paypal.order.response; 
import java.util.List;

import com.cheetah.payments.paypal.order.Amount;
import com.cheetah.payments.paypal.order.Item; 
public class PurchaseUnitResponse{
    public String reference_id;
    public Amount amount;
    public Payee payee;
    public List<Item> items;
}
