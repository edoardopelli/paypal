package com.cheetah.payments.paypal.order.request; 
import java.util.ArrayList;

import com.cheetah.payments.paypal.order.Amount;
import com.cheetah.payments.paypal.order.Item; 
public class PurchaseUnitRequest{
    public ArrayList<Item> items;
    public Amount amount;
}
