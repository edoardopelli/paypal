package com.cheetah.payments.paypal.plan.request; 
import java.util.List;

import com.cheetah.payments.paypal.plan.BillingCycle;
import com.cheetah.payments.paypal.plan.PaymentPreferences;
import com.cheetah.payments.paypal.plan.Taxes; 
public class PlanRequest{
    public String product_id;
    public String name;
    public String description;
    public String status;
    public List<BillingCycle> billing_cycles;
    public PaymentPreferences payment_preferences;
    public Taxes taxes;
}
