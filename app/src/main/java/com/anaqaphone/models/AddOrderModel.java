package com.anaqaphone.models;

import android.content.Context;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;

import com.anaqaphone.R;

import java.io.Serializable;
import java.util.List;

public class AddOrderModel extends BaseObservable implements Serializable {
    private List<ItemCartModel> products;
    private String address;
    private String details;
    private double longitude;
    private double latitude;
    private double total_price;
    private String order_date;
    private String order_time;
    private String coupon_id;
    private String payment_type;

    public ObservableField<String> error_address = new ObservableField<>();


    public AddOrderModel() {
        setAddress("");
        setLatitude(0.0);
        setLongitude(0.0);
        setTotal_price(0.0);
        setOrder_date("");
        setOrder_time("");
        setDetails("");
        setPayment_type("");

    }

    public boolean isStep1Valid(Context context) {
        if (!address.trim().isEmpty()) {
            error_address.set(null);
            return true;
        } else {
            error_address.set(context.getString(R.string.field_required));
            return false;
        }
    }

//    public boolean isStep2Valid(Context context) {
//        if (order_date != 0 && order_time != 0) {
//            return true;
//        } else {
//
//            if (date == 0) {
//                Toast.makeText(context, R.string.ch_date, Toast.LENGTH_SHORT).show();
//            }
//
//            if (time == 0) {
//                Toast.makeText(context, R.string.ch_time, Toast.LENGTH_SHORT).show();
//
//            }
//            return false;
//        }
//    }

    public boolean isStep3Valid(Context context) {
        if (!payment_type.isEmpty()) {
            return true;
        } else {
            Toast.makeText(context, R.string.ch_payment_type, Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public List<ItemCartModel> getProducts() {
        return products;
    }

    public void setProducts(List<ItemCartModel> products) {
        this.products = products;
    }

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(String coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }
}
