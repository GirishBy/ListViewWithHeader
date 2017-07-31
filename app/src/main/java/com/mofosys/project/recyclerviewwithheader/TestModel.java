package com.mofosys.project.recyclerviewwithheader;

import java.util.Date;

/**
 * Created by girish on 29/6/17.
 */

public class TestModel {

    private String product_name;
    private String supplier_product_price;
    private String product_ref_number;
    private String shipment_qty;
    private Date date_d;


    public Date getDate_d() {
        return date_d;
    }

    public void setDate_d(Date date_d) {
        this.date_d = date_d;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSupplier_product_price() {
        return supplier_product_price;
    }

    public void setSupplier_product_price(String supplier_product_price) {
        this.supplier_product_price = supplier_product_price;
    }

    public String getProduct_ref_number() {
        return product_ref_number;
    }

    public void setProduct_ref_number(String product_ref_number) {
        this.product_ref_number = product_ref_number;
    }

    public String getShipment_qty() {
        return shipment_qty;
    }

    public void setShipment_qty(String shipment_qty) {
        this.shipment_qty = shipment_qty;
    }
}
