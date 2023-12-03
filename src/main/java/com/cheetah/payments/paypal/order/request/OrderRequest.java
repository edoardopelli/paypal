package com.cheetah.payments.paypal.order.request; 
import java.util.ArrayList; 
public class OrderRequest{
    public String intent;
    public ArrayList<PurchaseUnitRequest> purchase_units;
    public ApplicationContext application_context;
}
