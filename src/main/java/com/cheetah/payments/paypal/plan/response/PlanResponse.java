package com.cheetah.payments.paypal.plan.response; 
import java.util.Date;
import java.util.List;

import com.cheetah.payments.paypal.plan.BillingCycle;
import com.cheetah.payments.paypal.plan.PaymentPreferences;
import com.cheetah.payments.paypal.plan.Taxes; 
public class PlanResponse{
    public String id;
    public String product_id;
    public String name;
    public String status;
    public String description;
    public String usage_type;
    public List<BillingCycle> billing_cycles;
    public PaymentPreferences payment_preferences;
    public Taxes taxes;
    public boolean quantity_supported;
    public Date create_time;
    public Date update_time;
    public List<Link> links;
}
